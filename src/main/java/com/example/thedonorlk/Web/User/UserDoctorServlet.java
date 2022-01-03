package com.example.thedonorlk.Web.User;

import com.example.thedonorlk.Bean.User.UserDoctorBean;
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

@WebServlet("/userDoctor")
public class UserDoctorServlet extends HttpServlet {
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
            listUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userDoctor");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <UserDoctorBean> listUser = userDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/doctors.jsp");
        dispatcher.forward(request, response);
    }
}