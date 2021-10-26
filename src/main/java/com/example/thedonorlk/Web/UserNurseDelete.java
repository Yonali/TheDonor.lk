package com.example.thedonorlk.Web;

import com.example.thedonorlk.Database.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userNurseDelete")
public class UserNurseDelete extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserNurseDAO userDAO;
    public void init() {
        userDAO = new UserNurseDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            deleteUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Unable to delete user");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userNurse");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.deleteUser(id);
        response.sendRedirect("./userNurse");
    }
}