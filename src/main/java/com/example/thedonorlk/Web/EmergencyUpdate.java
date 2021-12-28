package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.EmergencyBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.EmergencyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/emergencyUpdate")
public class EmergencyUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private EmergencyDAO emergencyDAO;
    public void init() {
        emergencyDAO = new EmergencyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("emergency");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String blood_group = request.getParameter("Blood_Group");
        String date = request.getParameter("Date");
        String time = request.getParameter("Time");
        String status = request.getParameter("Status");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        EmergencyBean newEmergency = new EmergencyBean(id, blood_group, date, time, status, bloodbank_code);

            if (emergencyDAO.updateUser(newEmergency)) {
                response.sendRedirect("./emergency");
            } else {
                request.setAttribute("error","Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("emergency");
                dispatcher.forward(request, response);
            }
    }
}