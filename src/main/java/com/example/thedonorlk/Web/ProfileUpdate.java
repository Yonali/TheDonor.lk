package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.LoginBean;
import com.example.thedonorlk.Bean.ProfileBean;
import com.example.thedonorlk.Database.LoginDAO;
import com.example.thedonorlk.Database.ProfileDAO;
import com.example.thedonorlk.Database.User.UserAdminDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profileUpdate")
@MultipartConfig
public class ProfileUpdate extends HttpServlet {
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
            profileChange(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void profileChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProfileBean profileBean = new ProfileBean();
        profileBean.setId(String.valueOf(id));

        Part filePart = request.getPart("image");
        if (filePart != null) {
            profileBean.setProfile(filePart.getInputStream());
        }

        String role = request.getParameter("role");
        String redirect = "dashboard";
        if (role.equals("Donor")) {
            redirect = "donorProfile";
        }
        if (profileDAO.updateProfile(profileBean)) {
            response.sendRedirect("./" + redirect);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher(redirect);
            dispatcher.forward(request, response);
        }

    }
}