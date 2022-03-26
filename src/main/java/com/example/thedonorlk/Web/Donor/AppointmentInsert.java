package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DonationDAO;
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
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@WebServlet("/appointmentInsert")
public class AppointmentInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private AppointmentDAO appointmentDAO;
    public DonorDAO donorDAO;
    private UserBloodBankDAO bloodBankDAO;
    private NotificationDAO notificationDAO;
    private DonationDAO donationDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        appointmentDAO = new AppointmentDAO();
        donorDAO = new DonorDAO();
        bloodBankDAO = new UserBloodBankDAO();
        notificationDAO = new NotificationDAO();
        donationDAO = new DonationDAO();
        bloodbankDAO = new UserBloodBankDAO();
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
                appointment_date + ", Time - " + appointment_time + ", Venue - " + bloodbank_code + ". You will be notified with the appointment confirmation very soon, Thank you";
        NotificationBean donor_notification = new NotificationBean(0,Integer.parseInt(donor_id), 0,"New Appointment",message,"","");
        String bb_message = donor.getFirst_name() + " has made an appointment on, Date - " +
                appointment_date + ", Time - " + appointment_time + ". Please respond at the earliest, Thank you";
        NotificationBean bb_notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodbank_code), Integer.parseInt(donor_id),"New Appointment",bb_message,"","");

        String last_date = donationDAO.selectLastDonationDate(donor.getNic());
        LocalDate today = LocalDate.now();
        Period period = Period.ofMonths(5);
        if (!last_date.equals("")) {
            period = Period.between(LocalDate.parse(last_date), LocalDate.parse(appointment_date));
        }

        if (period.getYears() == 0 && period.getMonths() < 4) {
            List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
            request.setAttribute("listBloodBank", listBloodBank);
            request.setAttribute("error", "You have donated within last 4 months, Please make an appointment after " + LocalDate.parse(last_date).plusDays(121));
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/donor/appointmentsForm.jsp");
            dispatcher.forward(request, response);
        } else{
            if (appointmentDAO.insertUser(newAppointment)) {
                notificationDAO.insertNotificaion(donor_notification);
                notificationDAO.insertNotificaion(bb_notification);

                request.setAttribute("SendTo", donor.getContact());
                request.setAttribute("Message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
                dispatcher.forward(request, response);
            }
        }
    }
}