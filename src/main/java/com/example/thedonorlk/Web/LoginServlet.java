package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.LoginBean;
import com.example.thedonorlk.Bean.UserDonorBean;
import com.example.thedonorlk.Database.LoginDAO;
import com.example.thedonorlk.Database.UserDonorDAO;
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
            HttpSession session = request.getSession();
            session.setAttribute("username",loginBean.getUsername());
            session.setAttribute("role", role);

            // Check user role and redirect accordingly
            if (!role.equals("donor")) {
                response.sendRedirect("./view/non_donor/dashboard_index.jsp");
            } else {
                UserDonorDAO userDAO = new UserDonorDAO();
                UserDonorBean userBean = userDAO.selectUser(username);
                session.setAttribute("name", userBean.getFname() + " " + userBean.getLname());

                response.sendRedirect("./view/donor/timeline.jsp");
            }
        } else {
            request.setAttribute("error","Incorrect Username or Password");
            request.getRequestDispatcher("./login.jsp").forward(request, response);
        }
    }
}
