package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.EmergencyBean;
import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.EmergencyDAO;
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

@WebServlet("/emergencyShowEditForm")
public class EmergencyShowEditForm extends HttpServlet {

    private EmergencyDAO emergencyDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        emergencyDAO = new EmergencyDAO();
        bloodbankDAO = new UserBloodBankDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showEditForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmergencyBean emergency = emergencyDAO.selectEmergency(id);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/emergencyForm.jsp");
        request.setAttribute("user", emergency);
        dispatcher.forward(request, response);
    }
}
