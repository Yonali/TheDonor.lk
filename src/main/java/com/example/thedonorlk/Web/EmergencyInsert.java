package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.EmergencyBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.EmergencyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/emergencyInsert")
public class EmergencyInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private EmergencyDAO emergencyDAO;
    private DonorDAO donorDAO;
    public void init() {
        emergencyDAO = new EmergencyDAO();
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertEmergency(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("emergency");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertEmergency(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        SimpleDateFormat date_formatter = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm");
        Date now = new Date();
        String date = date_formatter.format(now);
        String time = time_formatter.format(now);

        String blood_group = request.getParameter("Blood_Group");
        /*String date = request.getParameter("Date");
        String time = request.getParameter("Time");*/
        String status = "Open";
        String bloodbank_code = request.getParameter("BloodBank_Code");
        EmergencyBean newEmergency = new EmergencyBean(0, blood_group, date, time, status, bloodbank_code);

            if (emergencyDAO.insertUser(newEmergency)) {
                String message = blood_group + " blood is required urgently at your nearest blood bank '" + bloodbank_code + "'. " +
                        "Please visit and join with us to donate blood. " +
                        "#Your precious blood at this critical time can save more lives #TheDonor.lk";

                List<DonorBean> donor = donorDAO.selectAllDonorsByBloodbankAndGroup(bloodbank_code, blood_group);
                request.setAttribute("SendToDonorList", donor);
                request.setAttribute("Message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("emergency");
                dispatcher.forward(request, response);
            }
    }
}