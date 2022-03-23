package com.example.thedonorlk.Web.User;

import com.example.thedonorlk.Bean.User.UserNurseBean;
import com.example.thedonorlk.Database.User.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userNurseInsert")
public class UserNurseInsert extends HttpServlet {
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
            insertUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userNurse");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String contact = request.getParameter("contact");
        String nic = request.getParameter("nic");
        String section = request.getParameter("section");
        String bloodbank_code = request.getParameter("bloodbank_code");
        UserNurseBean newUser = new UserNurseBean(0, username, first_name, last_name, contact, nic, username, section, bloodbank_code);

        if (!userDAO.validateUsername(newUser)) {
            if (userDAO.insertUser(newUser)) {
                response.sendRedirect("./userNurse");
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/nurseForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}