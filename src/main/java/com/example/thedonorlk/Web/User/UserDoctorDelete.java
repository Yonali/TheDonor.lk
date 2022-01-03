package com.example.thedonorlk.Web.User;

import com.example.thedonorlk.Database.User.UserDoctorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userDoctorDelete")
public class UserDoctorDelete extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserDoctorDAO userDAO;
    public void init() {
        userDAO = new UserDoctorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            deleteUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Unable to delete user");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userDoctor");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("./userDoctor");
    }
}