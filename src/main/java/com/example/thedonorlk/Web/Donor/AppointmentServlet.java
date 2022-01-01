package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.Donor.AppointmentBean;
import com.example.thedonorlk.Database.Donor.AppointmentDAO;
import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Database.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/appointment_donor")
public class AppointmentServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private AppointmentDAO appointmentDAO;
    private UserBloodBankDAO userBloodBankDAO;
    public void init() {
        appointmentDAO = new AppointmentDAO();
        userBloodBankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <AppointmentBean> listAppointment = appointmentDAO.selectAllAppointments();
        request.setAttribute("listAppointment", listAppointment);
        List <UserBloodBankBean> listBloodBank = userBloodBankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/donor/appointments.jsp");
        dispatcher.forward(request, response);
    }
}