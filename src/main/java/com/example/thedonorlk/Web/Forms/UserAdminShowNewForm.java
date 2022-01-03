package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.UserAdminBean;
import com.example.thedonorlk.Database.UserAdminDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userAdminShowNewForm")
public class UserAdminShowNewForm extends HttpServlet {

    private UserAdminDAO userDAO;
    public void init() {
        userDAO = new UserAdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        showNewForm(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/adminForm.jsp");
        dispatcher.forward(request, response);
    }
}
