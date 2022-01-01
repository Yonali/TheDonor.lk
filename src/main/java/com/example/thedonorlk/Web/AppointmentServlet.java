package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.AppointmentDonorBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Database.AppointmentDAO;
import com.example.thedonorlk.Database.CampaignDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/appointment")
public class AppointmentServlet extends HttpServlet {
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
            listUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <AppointmentDonorBean> listAppointment = appointmentDAO.selectAllAppointments();
        request.setAttribute("listAppointment", listAppointment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/appointments.jsp");
        dispatcher.forward(request, response);
    }
}