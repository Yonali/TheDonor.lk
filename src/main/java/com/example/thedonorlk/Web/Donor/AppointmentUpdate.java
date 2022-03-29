package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.AppointmentBean;
import com.example.thedonorlk.Database.Donor.AppointmentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/appointmentUpdate")
public class AppointmentUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private AppointmentDAO appointmentDAO;
    public void init() {
        appointmentDAO = new AppointmentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment_donor");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        String appointment_time = request.getParameter("Appointment_Time");
        String appointment_date = request.getParameter("Appointment_Date");
        String donor_id = request.getParameter("Donor_ID");
        AppointmentBean appointment = new AppointmentBean(id, name, bloodbank_code, appointment_time, appointment_date, donor_id, "New");

            if (appointmentDAO.updateAppointment(appointment)) {
                response.sendRedirect("./appointment_donor");
            }
    }
}