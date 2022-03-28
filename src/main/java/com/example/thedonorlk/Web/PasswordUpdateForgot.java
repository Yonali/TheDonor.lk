package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.LoginBean;
import com.example.thedonorlk.Database.LoginDAO;
import com.example.thedonorlk.Database.ProfileDAO;
import com.example.thedonorlk.Database.User.ForgotPasswordDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/passwordUpdateForgot")
public class PasswordUpdateForgot extends HttpServlet {

    private ProfileDAO profileDAO;
    private LoginDAO loginDAO;
    private ForgotPasswordDAO forgotDAO;
    public void init() {
        profileDAO = new ProfileDAO();
        loginDAO = new LoginDAO();
        forgotDAO = new ForgotPasswordDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            passwordChange(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("./forgot.jsp");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void passwordChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String email = request.getParameter("email");
        String otp = request.getParameter("otp");
        String hash_otp = DigestUtils.sha256Hex(otp);

        int id = forgotDAO.selectUserID(email);

        String new_password = request.getParameter("pwd");
        String cnfrm_password = request.getParameter("cnfrm_pwd");
        String hash_new_pwd = DigestUtils.sha256Hex(new_password);
        String hash_cnfrm_pwd = DigestUtils.sha256Hex(cnfrm_password);

        if (forgotDAO.validateOTP(email, hash_otp)) {
            if (new_password.length() < 8) {
                request.setAttribute("error", "Password should be Minimum 8 Characters long, Please Try Again");
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./passwordChange.jsp");
                dispatcher.forward(request, response);
            } else if (!hash_new_pwd.equals(hash_cnfrm_pwd)) {
                request.setAttribute("error", "Passwords do not match, Please Try Again");
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./passwordChange.jsp");
                dispatcher.forward(request, response);
            } else {
                if (profileDAO.updatePassword(id, hash_new_pwd)) {
                    forgotDAO.deleteOTPRecord(email);

                    request.setAttribute("error","Password successfully changed");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("error", "Something went wrong, Please Try Again");
                    request.setAttribute("email", email);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./passwordChange.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else {
            request.setAttribute("error", "Incorrect OTP, Please Try Again");
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./passwordChange.jsp");
            dispatcher.forward(request, response);
        }
    }
}