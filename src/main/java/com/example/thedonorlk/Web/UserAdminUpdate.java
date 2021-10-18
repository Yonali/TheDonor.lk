package com.example.thedonorlk.Web;

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
import java.util.List;

@WebServlet("/userAdminUpdate")
public class UserAdminUpdate extends HttpServlet {
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
            updateUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        UserAdminBean book = new UserAdminBean(id, username);
        userDAO.updateUser(book);
        response.sendRedirect("./userAdmin");
    }
}