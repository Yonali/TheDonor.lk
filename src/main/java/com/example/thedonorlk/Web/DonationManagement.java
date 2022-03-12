package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Database.BloodStockDAO;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonationDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donationManagement")
public class DonationManagement extends HttpServlet {
    private DonationDAO donationDAO;
    private DonorDAO donorDAO;
    private BloodStockDAO stockDAO;
    public void init() {
        donationDAO = new DonationDAO();
        donorDAO = new DonorDAO();
        stockDAO = new BloodStockDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String bloodbank = (String) session.getAttribute("bloodbank");
            String type = request.getParameter("type");
            int id = Integer.parseInt(request.getParameter("id"));

            DonationBean donation = donationDAO.selectDonation(id);
            DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donation.getDonor_id()));
            String message = "";

            if (type.equals("Accept")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Counselled");

                int queue = donationDAO.countDonations(bloodbank, "Counselled");
                message = "Doctor counselled successfully, Please go to the Bleeding Area next. " +
                        "Your queue number is "+ queue + " and approx waiting time is " + ((queue*20)/60) + "hrs " + ((queue*20)%60) + "mins";

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
                dispatcher.forward(request, response);
            } else if (type.equals("DoctorCancel")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Cancelled");

                message = "Donation is Cancelled. Thank you for your time to help save lives.";

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
                dispatcher.forward(request, response);
            } else if (type.equals("Cancel")) {
                donationDAO.updateStatus(id, "Cancelled");

                message = "Donation is Cancelled. Thank you for your time to help save lives.";

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
                dispatcher.forward(request, response);
            } else if (type.equals("Complete")) {
                //Insert Blood Record here
                String blood_barcode = request.getParameter("barcode");
                String blood_product = "Whole Blood";
                String blood_group = "";
                String bloodbank_code = request.getParameter("bank");
                String status = "Whole Blood";
                String collected_date = "";

                BloodStockBean newStock = new BloodStockBean(0, blood_barcode, blood_product, blood_group,
                        bloodbank_code, status, collected_date, collected_date, collected_date);

                if (stockDAO.insertStock(newStock)) {
                    donationDAO.updateStatus(id, "Completed");

                    message = "Thank you for helping to save lives with your precious time and blood, " +
                            "Many people would not be alive today if it wasn't for the generosity of our donors.";

                    request.setAttribute("SendTo", donor.getContact());
                    request.setAttribute("Message", message);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
                    dispatcher.forward(request, response);
                }
            } else if (type.equals("Deferr")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                String donor_id = request.getParameter("donor_id");
                String deferral_type = request.getParameter("Deferral_Type");

                donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Deferred");
                donationDAO.updateDonorStatus(donor_id, deferral_type.equals("T_Deferral") ? "T_Deferred": "P_Deferred");

                String doctor_id = request.getParameter("user_id");
                String deferral_remark = request.getParameter("Deferral_Remark");
                String start_date = request.getParameter("Start_Date");
                String end_date = request.getParameter("End_Date");

                DeferralHistoryBean newDeferral = new DeferralHistoryBean(id, donor_id, doctor_id, deferral_remark, start_date, deferral_type.equals("P_Deferral") ? null: end_date, deferral_type, "");

                if (donorDAO.insertDeferralHistory(newDeferral)) {
                    message = "Thank you for your time to help save lives. " +
                            (deferral_type.equals("T_Deferral") ? "Please visit your nearest blood bank after " + end_date + " to donate blood and save lives again.": "");

                    request.setAttribute("SendTo", donor.getContact());
                    request.setAttribute("Message", message);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
                    dispatcher.forward(request, response);
                }
            } else if (type.equals("DeferrEdit")) {
                //SMS NOT REQUIRED
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                String donor_id = request.getParameter("donor_id");
                String deferral_type = request.getParameter("Deferral_Type");

                //SMS NOT REQUIRED
                /*donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Deferred");
                donationDAO.updateDonorStatus(donor_id, deferral_type.equals("T_Deferral") ? "T_Deferred": "P_Deferred");*/

                String doctor_id = request.getParameter("user_id");
                String deferral_remark = request.getParameter("Deferral_Remark");
                String start_date = request.getParameter("Start_Date");
                String end_date = request.getParameter("End_Date");

                DeferralHistoryBean newDeferral = new DeferralHistoryBean(id, donor_id, doctor_id, deferral_remark, start_date, deferral_type.equals("P_Deferral") ? null: end_date, deferral_type, "");

                //SMS NOT REQUIRED
                if (donorDAO.updateDeferralHistory(newDeferral)) {
                    //response.sendRedirect("./donor");
                    request.setAttribute("error","Please do relevant status modification to donor");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("donor");
                    dispatcher.forward(request, response);
                }
            }
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

}