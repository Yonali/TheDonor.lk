package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.LoginBean;
import com.example.thedonorlk.Bean.User.UserAdminBean;
import com.example.thedonorlk.Database.LoginDAO;
import com.example.thedonorlk.Database.ProfileDAO;
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

@WebServlet("/passwordUpdate")
public class PasswordUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private ProfileDAO profileDAO;
    private LoginDAO loginDAO;
    public void init() {
        profileDAO = new ProfileDAO();
        loginDAO = new LoginDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            passwordChange(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void passwordChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("Cur_Password");
        String hash_pwd = DigestUtils.sha256Hex(password);
        LoginBean login = new LoginBean();
        login.setUsername(username);
        login.setPassword(hash_pwd);

        String new_password = request.getParameter("New_Password");
        String cnfrm_password = request.getParameter("Cnfrm_Password");
        String hash_new_pwd = DigestUtils.sha256Hex(new_password);
        String hash_cnfrm_pwd = DigestUtils.sha256Hex(cnfrm_password);

        String role = request.getParameter("role");
        String redirect = "dashboard";
        if (role.equals("Donor")) {
            redirect = "donorShowProfile?id=" + id;
        }
        if (!loginDAO.validate(login)) {
            request.setAttribute("error", "Incorrect Password, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
            dispatcher.forward(request, response);
        } else if (new_password.length() < 8) {
            request.setAttribute("error", "Password should be Minimum 8 Characters long, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
            dispatcher.forward(request, response);
        } else if (!hash_new_pwd.equals(hash_cnfrm_pwd)) {
            request.setAttribute("error", "Passwords do not match, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
            dispatcher.forward(request, response);
        } else {
            if (profileDAO.updatePassword(id, hash_new_pwd)) {
                response.sendRedirect("./" + redirect);
            } else {
                request.setAttribute("error", "Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
                dispatcher.forward(request, response);
            }
        }
    }
}