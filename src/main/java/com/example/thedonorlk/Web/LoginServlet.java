package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Database.*;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDAO loginDAO = new LoginDAO();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(DigestUtils.sha256Hex(password));

        if (loginDAO.validate(loginBean)) {
            String role = loginDAO.getUserRole(loginBean);
            int id = loginDAO.getUserID(loginBean);
            HttpSession session = request.getSession();
            session.setAttribute("username",loginBean.getUsername());
            session.setAttribute("role", role);

            // Check user role and redirect accordingly
            if (role.equals("donor")) {
                UserDonorDAO userDAO = new UserDonorDAO();
                UserDonorBean userBean = userDAO.selectUser(username);
                session.setAttribute("name", userBean.getFname() + " " + userBean.getLname());

                response.sendRedirect("./view/donor/timeline.jsp");
            } else {
                if (role.equals("admin")) {
                    UserAdminDAO userDAO = new UserAdminDAO();
                    UserAdminBean userBean = userDAO.selectUser(id);
                } else {
                    if (role.equals("bloodbank")) {
                        UserBloodBankDAO userDAO = new UserBloodBankDAO();
                        UserBloodBankBean userBean = userDAO.selectUser(id);
                        session.setAttribute("bloodbank", userBean.getCode());
                    } else if (role.equals("doctor")) {
                        UserDoctorDAO userDAO = new UserDoctorDAO();
                        UserDoctorBean userBean = userDAO.selectUser(id);
                        session.setAttribute("bloodbank", userBean.getBloodbank_code());
                    } else if (role.equals("nurse")) {
                        UserNurseDAO userDAO = new UserNurseDAO();
                        UserNurseBean userBean = userDAO.selectUser(id);
                        session.setAttribute("bloodbank", userBean.getBloodbank_code());
                    }
                }

                response.sendRedirect("./view/non_donor/dashboard_index.jsp");
            }
        } else {
            request.setAttribute("error","Incorrect Username or Password");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
    }
}
