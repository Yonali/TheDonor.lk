package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Bean.DonorCardBean;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/donationInsert")
public class DonationInsert extends HttpServlet {
    private DonationDAO donationDAO;
    public DonorDAO donorDAO;
    public void init() {
        donationDAO = new DonationDAO();
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertDonation(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertDonation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);

        String bloodbank_code = (String) session.getAttribute("bloodbank");
        String user_id = String.valueOf(session.getAttribute("user_id"));
        String user_role = (String) session.getAttribute("role");
        String donor_id = request.getParameter("Donor_ID");
        String blood_id = request.getParameter("Blood_Barcode");
        String campaign_id = request.getParameter("Campaign_ID");

        DonationBean newDonation = new DonationBean(0, "New", "date", "time",
                bloodbank_code, user_role.equals("nurse") ? user_id : null, null, donor_id, blood_id,
                campaign_id.equals("null") ? null : campaign_id, "appointment_id", "donor_name", "donor_nic");

        DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donor_id));
        int queue = donationDAO.countDonations(bloodbank_code, "New") + 1;
        String message = "Dear " + donor.getFirst_name() + ", Thank you for willing to save a life, Please go to the Doctor to counsel first. " +
                "Your queue number is "+ queue + " and approx waiting time is " + ((queue*10)/60) + "hrs " + ((queue*10)%60) + "mins";

        if (donationDAO.insertDonation(newDonation)) {
            request.setAttribute("SendTo", donor.getContact());
            request.setAttribute("Message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
            dispatcher.forward(request, response);
        }
    }
}