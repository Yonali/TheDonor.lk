package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Database.Donor.AppointmentDAO;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.NotificationDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/appointmentInsert")
public class AppointmentInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private AppointmentDAO appointmentDAO;
    public DonorDAO donorDAO;
    private UserBloodBankDAO bloodBankDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        appointmentDAO = new AppointmentDAO();
        donorDAO = new DonorDAO();
        bloodBankDAO = new UserBloodBankDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertAppointment(request, response);
        } catch (SQLException | ParseException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertAppointment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {

        String name = request.getParameter("name");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        String appointment_time = request.getParameter("Appointment_Time");
        String appointment_date = request.getParameter("Appointment_Date");
        String donor_id = request.getParameter("Donor_ID");
        AppointmentBean newAppointment = new AppointmentBean(Integer.parseInt(donor_id), name, bloodbank_code, appointment_time, appointment_date, donor_id, "New");


        //  LocalDate today = LocalDate.now(); // Today's date here
        LocalDate now = LocalDate.now(); // Today's date here
        //object of SimpleDateFormat class
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//dates to be compare
        Date date1 = sdf.parse("appointment_date");
        Date today = sdf.parse(String.valueOf(now));
//prints dates
        System.out.println("Date 1: " + sdf.format(date1));
        System.out.println("Date 2: " + sdf.format(today));
//comparing dates



        DonorCardBean donor = donorDAO.selectDonorCardByID(Integer.parseInt(donor_id));
        String message = "Dear " + donor.getFirst_name() + ", Your below appointment is recorded, Date - " +
                appointment_date + ", Time - " + appointment_time + ", Venue - " + bloodbank_code + ". You will be notified with the appointment confirmation very soon, Thank you";
        NotificationBean donor_notification = new NotificationBean(0,Integer.parseInt(donor_id), 0,"New Appointment",message,"","");
        String bb_message = donor.getFirst_name() + " has made an appointment on, Date - " +
                appointment_date + ", Time - " + appointment_time + ". Please respond at the earliest, Thank you";
        NotificationBean bb_notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodbank_code), Integer.parseInt(donor_id),"New Appointment",bb_message,"","");

        if (appointmentDAO.insertUser(newAppointment)) {
            notificationDAO.insertNotificaion(donor_notification);
            notificationDAO.insertNotificaion(bb_notification);

            request.setAttribute("SendTo", donor.getContact());
            request.setAttribute("Message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
        }
        else if(date1.compareTo(today) > 0)
        {
            System.out.println("Date 1 comes after Date 2");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
        }
        else if(date1.compareTo(today) < 0)
        {
            System.out.println("Date 1 comes before Date 2");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
        }
        else if(date1.compareTo(today) == 0)
        {
            System.out.println("Both dates are equal");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
        }
    }
}