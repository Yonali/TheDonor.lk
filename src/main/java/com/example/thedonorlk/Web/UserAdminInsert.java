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

@WebServlet("/userAdminInsert")
public class UserAdminInsert extends HttpServlet {
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
            insertUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userAdmin");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        UserAdminBean newUser = new UserAdminBean(0, username);

        if (!userDAO.validateUsername(newUser)) {
            if (userDAO.insertUser(newUser)) {
                response.sendRedirect("./userAdmin");
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/adminForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}