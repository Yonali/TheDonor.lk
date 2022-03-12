package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.BloodStockDAO;
import com.example.thedonorlk.Database.DonationDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodStockUpdate")
public class BloodStockUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodStockDAO stockDAO;
    private DonationDAO donationDAO;
    private DonorDAO donorDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
        donationDAO = new DonationDAO();
        donorDAO = new DonorDAO();
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

        if (stockDAO.updateStockStatus(id, status)) {
            if (status.equals("Transfused")) {
                BloodStockBean stock = stockDAO.selectStock(id);
                DonationBean donation = donationDAO.selectDonationByBloodBarcode(stock.getBlood_barcode());
                DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donation.getDonor_id()));

                String message = "Thank you, your precious blood donation helped save a life today, " +
                        "Thank you for your generosity, It means a lot for the patient and the family. " +
                        "#Donating Blood Makes a Big Difference in the Lives of Others #TheDonor.lk";

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
            dispatcher.forward(request, response);
        }
    }
}