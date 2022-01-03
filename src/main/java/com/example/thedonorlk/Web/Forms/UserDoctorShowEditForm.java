package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;
import com.example.thedonorlk.Database.User.UserDoctorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userDoctorShowEditForm")
public class UserDoctorShowEditForm extends HttpServlet {

    private UserDoctorDAO userDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        userDAO = new UserDoctorDAO();
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
        UserDoctorBean existingUser = userDAO.selectUser(id);
        request.setAttribute("user", existingUser);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/doctorForm.jsp");
        dispatcher.forward(request, response);
    }
}
