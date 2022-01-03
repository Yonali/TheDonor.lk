package com.example.thedonorlk.Web.User;

import com.example.thedonorlk.Bean.User.UserAdminBean;
import com.example.thedonorlk.Database.User.UserAdminDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userAdmin")
public class UserAdminServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserAdminDAO userDAO;
    public void init() {
        userDAO = new UserAdminDAO();
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
        List < UserAdminBean > listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/admin.jsp");
        dispatcher.forward(request, response);
    }
}