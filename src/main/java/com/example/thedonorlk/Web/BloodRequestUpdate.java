package com.example.thedonorlk.Web;

import com.example.thedonorlk.Database.BloodRequestDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodRequestUpdate")
public class BloodRequestUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodRequestDAO requestDAO;

    public void init() {
        requestDAO = new BloodRequestDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateRequest(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        if (status.equals("Cancelled")) {
            if (requestDAO.updateRequestStatus(id, status)) {
                response.sendRedirect("./bloodRequestSent");
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
                dispatcher.forward(request, response);
            }
        } else {
            if (requestDAO.updateRequestStatus(id, status)) {
                response.sendRedirect("./bloodRequestReceived");
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestReceived");
                dispatcher.forward(request, response);
            }
        }
    }
}