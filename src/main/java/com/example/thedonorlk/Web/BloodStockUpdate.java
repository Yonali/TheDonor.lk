package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodStockUpdate")
public class BloodStockUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodStockDAO stockDAO;
    private DonationDAO donationDAO;
    private DonorDAO donorDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
        donationDAO = new DonationDAO();
        donorDAO = new DonorDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateStock(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        String bank = request.getParameter("bank");

        HttpSession session = request.getSession(false);
        int notifier_id = (Integer) session.getAttribute("user_id");

        if (status.equals("Transfused")) {
            if (stockDAO.validate(id)) {
                if (stockDAO.updateStockStatus(id, status)) {
                    BloodStockBean stock = stockDAO.selectStock(id);
                    DonationBean donation = donationDAO.selectDonationByBloodBarcode(stock.getBlood_barcode());
                    DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donation.getDonor_id()));

                    String message = "Thank you, your precious blood helped save a life today, " +
                            "Thank you for your generosity, It means a lot for the patient and the family. " +
                            "#Donating Blood Makes a Big Difference in the Lives of Others #TheDonor.lk";

                    NotificationBean notification = new NotificationBean(0,Integer.parseInt(donation.getDonor_id()), notifier_id,"You saved a life!",message,"","");
                    notificationDAO.insertNotificaion(notification);

                    request.setAttribute("SendTo", donor.getContact());
                    request.setAttribute("Message", message);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("error", "Something went wrong, Please Try Again");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
                    dispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("error", "Blood product is expired, Please check");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
                dispatcher.forward(request, response);
            }
        } else {
            if (stockDAO.updateStockStatus(id, status)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
                dispatcher.forward(request, response);
            }
        }
        /*if (stockDAO.updateStockStatus(id, status)) {
            if (status.equals("Transfused")) {
                BloodStockBean stock = stockDAO.selectStock(id);
                DonationBean donation = donationDAO.selectDonationByBloodBarcode(stock.getBlood_barcode());
                DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donation.getDonor_id()));

                String message = "Thank you, your precious blood helped save a life today, " +
                        "Thank you for your generosity, It means a lot for the patient and the family. " +
                        "#Donating Blood Makes a Big Difference in the Lives of Others #TheDonor.lk";

                NotificationBean notification = new NotificationBean(0,Integer.parseInt(donation.getDonor_id()), notifier_id,"You saved a life!",message,"","");
                notificationDAO.insertNotificaion(notification);

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
            dispatcher.forward(request, response);
        }*/
    }
}