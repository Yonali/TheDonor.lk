package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DeferralHistoryBean;
import com.example.thedonorlk.Database.CampaignDAO;
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

@WebServlet("/donationManagement")
public class DonationManagement extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonationDAO donationDAO;
    private DonorDAO donorDAO;
    public void init() {
        donationDAO = new DonationDAO();
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String type = request.getParameter("type");

            int id = Integer.parseInt(request.getParameter("id"));
            if (type.equals("Accept")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Counselled");
                response.sendRedirect("./donation");
            } else if (type.equals("DoctorCancel")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Cancelled");
                response.sendRedirect("./donation");
            } else if (type.equals("Cancel")) {
                donationDAO.updateStatus(id, "Cancelled");
                response.sendRedirect("./donation");
            } else if (type.equals("Complete")) {
                donationDAO.updateStatus(id, "Completed");
                response.sendRedirect("./donation");

                //Insert Blood Record here

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
                    response.sendRedirect("./donation");
                }
            } else if (type.equals("DeferrEdit")) {
                int doc_id = Integer.parseInt(request.getParameter("user_id"));
                String donor_id = request.getParameter("donor_id");
                String deferral_type = request.getParameter("Deferral_Type");

                /*donationDAO.updateDoctor(id, doc_id);
                donationDAO.updateStatus(id, "Deferred");
                donationDAO.updateDonorStatus(donor_id, deferral_type.equals("T_Deferral") ? "T_Deferred": "P_Deferred");*/

                String doctor_id = request.getParameter("user_id");
                String deferral_remark = request.getParameter("Deferral_Remark");
                String start_date = request.getParameter("Start_Date");
                String end_date = request.getParameter("End_Date");

                DeferralHistoryBean newDeferral = new DeferralHistoryBean(id, donor_id, doctor_id, deferral_remark, start_date, deferral_type.equals("P_Deferral") ? null: end_date, deferral_type, "");

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

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("donation_id"));
        donationDAO.updateStatus(id, "Counselled");
        response.sendRedirect("./donation");
    }
}