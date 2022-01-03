package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userBloodBankShowEditForm")
public class UserBloodBankShowEditForm extends HttpServlet {

    private UserBloodBankDAO userBloodBankDAO;
    public void init() {
        userBloodBankDAO = new UserBloodBankDAO();
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
        UserBloodBankBean existingUser = userBloodBankDAO.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/bloodbankForm.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);
    }
}
