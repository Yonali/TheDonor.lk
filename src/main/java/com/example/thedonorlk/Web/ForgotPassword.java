package com.example.thedonorlk.Web;

import Controller.PasswordEmailGenerator;
import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Database.User.ForgotPasswordDAO;
import com.example.thedonorlk.Database.User.UserDoctorDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/forgotPassword")
public class ForgotPassword extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private ForgotPasswordDAO forgotDAO;
    public void init() {
        forgotDAO = new ForgotPasswordDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            forgot(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userDoctor");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void forgot(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("email");

        //Auto generate user password here
        PasswordEmailGenerator passwordEmailGenerator = new PasswordEmailGenerator();
        String otp = passwordEmailGenerator.generateOTP();
        String hash_otp = DigestUtils.sha256Hex(otp);

        if (forgotDAO.validateUsername(email)) {
            if (forgotDAO.insertOTP(email, hash_otp)) {
                //Send Email with credentials
                PasswordEmailGenerator mailDAO = new PasswordEmailGenerator();
                String message = "Dear User,\n\n"
                        + "Did you forget your password? Please use the below OTP to verify and reset your password.\n\n"
                        + "Email - " + email + "\n"
                        + "OTP - " + otp + "\n\n"
                        + "If you don't want to change your password or didn't request this, please ignore and delete this message.\n\n"
                        + "Thank you\nThedonor.lk";
                mailDAO.sendMail(email, "Password Reset | TheDonor.lk", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/login.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("error","Email is not registered with any account, Please try again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/forgot.jsp");
            dispatcher.forward(request, response);
        }
    }
}