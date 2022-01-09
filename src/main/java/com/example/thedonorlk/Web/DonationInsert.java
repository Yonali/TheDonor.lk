package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/donationInsert")
public class DonationInsert extends HttpServlet {
    private DonationDAO donationDAO;
    public void init() {
        donationDAO = new DonationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertDonation(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertDonation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);

        String bloodbank_code = (String)session.getAttribute("bloodbank");
        String user_id = String.valueOf(session.getAttribute("user_id"));
        String user_role = (String)session.getAttribute("role");
        String donor_id = request.getParameter("Donor_ID");
        String blood_id = request.getParameter("Blood_Barcode");

        DonationBean newDonation = new DonationBean(0, "New", "date", "time",
                bloodbank_code, user_role.equals("nurse") ? user_id: null, null, donor_id, blood_id,
                "campaign_id", "appointment_id", "donor_name", "donor_nic");

            if (donationDAO.insertDonation(newDonation)) {
                response.sendRedirect("./donation");
            }
    }
}