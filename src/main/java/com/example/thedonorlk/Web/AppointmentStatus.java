package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.AppointmentBean;
import com.example.thedonorlk.Bean.AppointmentDonorBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Database.AppointmentDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/appointmentStatus")
public class AppointmentStatus extends HttpServlet {
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
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");

        AppointmentDonorBean appointment = appointmentDAO.selectAppointment(id);
        String message = "Thank you, Your appointment is " + type + ", Date - " +
                appointment.getAppointment_date() + ", Time - " + appointment.getAppointment_time() + ". ";
        if (type.equals("Rejected")) {
            message = "Sorry, Your appointment is " + type + ", Date - " +
                    appointment.getAppointment_date() + ", Time - " + appointment.getAppointment_time() + ". ";
        }

        if (appointmentDAO.updateAppointment(id, type)) {
            request.setAttribute("SendTo", appointment.getDonor_contact());
            request.setAttribute("Message", message);

            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment");
            dispatcher.forward(request, response);
        }
    }
}