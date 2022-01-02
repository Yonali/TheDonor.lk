package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Bean.UserNurseBean;
import com.example.thedonorlk.Database.UserBloodBankDAO;
import com.example.thedonorlk.Database.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userNurseShowEditForm")
public class UserNurseShowEditForm extends HttpServlet {

    private UserNurseDAO userDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        userDAO = new UserNurseDAO();
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
        UserNurseBean existingUser = userDAO.selectUser(id);
        request.setAttribute("user", existingUser);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/nurseForm.jsp");
        dispatcher.forward(request, response);
    }
}
