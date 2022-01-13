package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.Donor.EmergencyBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;

import com.example.thedonorlk.Database.Donor.EmergencyDAO;
import com.example.thedonorlk.Database.DonorDAO;
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
import java.util.List;

@WebServlet("/emergency_donor")
public class EmergencyServlet extends HttpServlet {

    //private static final long serialVersionUID = 1 L;
    private EmergencyDAO emergencyDAO;
    private UserBloodBankDAO userBloodBankDAO;
    private DonorDAO donorDAO;
    public void init() {
        emergencyDAO = new EmergencyDAO();
        userBloodBankDAO = new UserBloodBankDAO();
        donorDAO = new DonorDAO();
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
        HttpSession session = request.getSession(false);
        int id = (Integer) session.getAttribute("user_id");

        DonorBean donor = donorDAO.selectDonor(id);

        List<EmergencyBean> listEmergency = emergencyDAO.selectAllEmergencyByBloodGroup(donor.getBlood_group());
        request.setAttribute("listEmergency", listEmergency);
        List <UserBloodBankBean> listBloodBank = userBloodBankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/donor/donor_emergency.jsp");
        dispatcher.forward(request, response);
    }
}
