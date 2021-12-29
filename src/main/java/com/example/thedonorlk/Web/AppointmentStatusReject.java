package com.example.thedonorlk.Web;

import com.example.thedonorlk.Database.AppointmentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/appointmentStatusReject")
public class AppointmentStatusReject extends HttpServlet {
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

            if (appointmentDAO.updateAppointment(id, "Rejected")) {
                response.sendRedirect("./appointment");
            } else {
                request.setAttribute("error","Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("appointment");
                dispatcher.forward(request, response);
            }
    }
}