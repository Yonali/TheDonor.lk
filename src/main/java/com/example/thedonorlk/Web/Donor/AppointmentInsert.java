package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.AppointmentBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Database.Donor.AppointmentDAO;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/appointmentInsert")
public class AppointmentInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private AppointmentDAO appointmentDAO;
    public DonorDAO donorDAO;
    public void init() {
        appointmentDAO = new AppointmentDAO();
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertAppointment(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String bloodbank_code = request.getParameter("BloodBank_Code");
        String appointment_time = request.getParameter("Appointment_Time");
        String appointment_date = request.getParameter("Appointment_Date");
        String donor_id = request.getParameter("Donor_ID");
        AppointmentBean newAppointment = new AppointmentBean(Integer.parseInt(donor_id), bloodbank_code, appointment_time, appointment_date, donor_id, "New");

        DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donor_id));
        String message = "Dear " + donor.getFirst_name() + ", Your below appointment is recorded, Date - " +
                appointment_date + ", Time - " + appointment_time + ". You will be notified with the appointment confirmation very soon, Thank you";

        if (appointmentDAO.insertUser(newAppointment)) {
            request.setAttribute("SendTo", donor.getContact());
            request.setAttribute("Message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
        }
    }
}