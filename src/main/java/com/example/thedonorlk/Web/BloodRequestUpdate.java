package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.NotificationDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodRequestUpdate")
public class BloodRequestUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodRequestDAO requestDAO;
    private UserBloodBankDAO bloodBankDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        requestDAO = new BloodRequestDAO();
        bloodBankDAO = new UserBloodBankDAO();
        notificationDAO = new NotificationDAO();
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
        BloodRequestBean bloodRequest = requestDAO.selectRequest(id);

        if (status.equals("Cancelled")) {
            String message =  "Blood Bank " + bloodRequest.getFrom_bloodbank_code() + " has cancelled their Blood request. " +
                    "Thank you ";
            NotificationBean notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getTo_bloodbank_code()), bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getFrom_bloodbank_code()),"Blood Request Cancelled",message,"","");
            if (requestDAO.updateRequestStatus(id, status)) {
                notificationDAO.insertNotificaion(notification);
                response.sendRedirect("./bloodRequestSent");
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
                dispatcher.forward(request, response);
            }
        } else if (status.equals("Declined")) {
            String message =  "Your blood request from " + bloodRequest.getTo_bloodbank_code() + " is Declined. " +
                    "Please try from another Blood Bank. Thank you ";
            NotificationBean notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getFrom_bloodbank_code()), bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getTo_bloodbank_code()),"Blood Request Declined",message,"","");
            if (requestDAO.updateRequestStatus(id, status)) {
                notificationDAO.insertNotificaion(notification);
                response.sendRedirect("./bloodRequestReceived");
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestReceived");
                dispatcher.forward(request, response);
            }
        } else {
            String message =  "Your blood request from " + bloodRequest.getTo_bloodbank_code() + " is Accepted. " +
                    "Await for the Blood Transfer. Thank you ";
            NotificationBean notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getFrom_bloodbank_code()), bloodBankDAO.selectIDFromBloodBankCode(bloodRequest.getTo_bloodbank_code()),"Blood Request Accepted",message,"","");
            if (requestDAO.updateRequestStatus(id, status)) {
                notificationDAO.insertNotificaion(notification);
                response.sendRedirect("./bloodRequestReceived");
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestReceived");
                dispatcher.forward(request, response);
            }
        }
    }
}