package com.example.thedonorlk.Web.User;

import Controller.PasswordEmailGenerator;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userBloodBankInsert")
public class UserBloodBankInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private UserBloodBankDAO userBloodBankDAO;
    public void init() {
        userBloodBankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userBloodBank");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String bg = request.getParameter("bg");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String add_street = request.getParameter("add_street");
        String add_city = request.getParameter("add_city");
        UserBloodBankBean newUser = new UserBloodBankBean(0, username, username, name, bg, contact, email, add_street, add_city);

        //Auto generate user password here
        PasswordEmailGenerator passwordEmailGenerator = new PasswordEmailGenerator();
        String password = passwordEmailGenerator.generatePassword();
        String hash_pwd = DigestUtils.sha256Hex(password);

        if (!userBloodBankDAO.validateUsername(newUser)) {
            if (userBloodBankDAO.insertUser(newUser, hash_pwd)) {
                //Send Email with credentials
                PasswordEmailGenerator mailDAO = new PasswordEmailGenerator();
                String message = "Dear " + name + ",\n\n"
                        + "Your new Blood Bank account credentials are as below.\n\n"
                        + "Username - " + username + "\n"
                        + "Password - " + password + "\n\n"
                        + "Thank you\nThedonor.lk";
                mailDAO.sendMail(email, "New Blood Bank Account | TheDonor.lk", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("userBloodBank");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/bloodbankForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}