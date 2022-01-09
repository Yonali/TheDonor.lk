package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.ProfileBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Bean.User.UserNurseBean;
import com.example.thedonorlk.Database.ProfileDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;
import com.example.thedonorlk.Database.User.UserDoctorDAO;
import com.example.thedonorlk.Database.User.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorShowSettingForm")
public class DonorShowSettingForm extends HttpServlet {

    private ProfileDAO profileDAO;
    private UserDoctorDAO doctorDAO;
    private UserNurseDAO nurseDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        profileDAO = new ProfileDAO();
        doctorDAO = new UserDoctorDAO();
        nurseDAO = new UserNurseDAO();
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
        String role = request.getParameter("role");

        if (role.equals("doctor")) {
            UserDoctorBean existingUser = doctorDAO.selectUser(id);
            request.setAttribute("user", existingUser);
        } else if (role.equals("nurse")) {
            UserNurseBean existingUser = nurseDAO.selectUser(id);
            request.setAttribute("user", existingUser);
        } else if (role.equals("bloodbank")) {
            UserBloodBankBean existingUser = bloodbankDAO.selectUser(id);
            request.setAttribute("user", existingUser);
        }

        ProfileBean profile = profileDAO.viewProfile(id);
        request.setAttribute("profile", profile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/settings.jsp");
        dispatcher.forward(request, response);
    }
}
