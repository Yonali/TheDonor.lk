package com.example.thedonorlk.Web.User;

import Controller.PasswordEmailGenerator;
import com.example.thedonorlk.Bean.User.UserAdminBean;
import com.example.thedonorlk.Database.User.UserAdminDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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
            //throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        UserAdminBean newUser = new UserAdminBean(0, username);

        //Auto generate user password here
        PasswordEmailGenerator passwordEmailGenerator = new PasswordEmailGenerator();
        String password = "Admin1234*";
        String hash_pwd = DigestUtils.sha256Hex(password);

        if (!userDAO.validateUsername(newUser)) {
            if (userDAO.insertUser(newUser, hash_pwd)) {
                //Send Email with credentials
                PasswordEmailGenerator mailDAO = new PasswordEmailGenerator();
                String message = "Dear " + username + ",\n\n"
                        + "Your new Admin account credentials are as below.\n\n"
                        + "Username - " + username + "\n"
                        + "Password - " + password + "\n\n"
                        + "Thank you\nThedonor.lk";
                mailDAO.sendMail(username, "New Admin Account | TheDonor.lk", message);

                response.sendRedirect("./userAdmin");
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/adminForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}