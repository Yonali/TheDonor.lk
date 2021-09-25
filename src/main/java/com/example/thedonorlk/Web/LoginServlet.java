package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.LoginBean;
import com.example.thedonorlk.Database.LoginDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDAO loginDao = new LoginDAO();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(DigestUtils.sha256Hex(password));

        if (loginDao.validate(loginBean)) {
            response.sendRedirect("./view/timeline.jsp");
        } else {
            //response.sendRedirect("./view/mainlogin.jsp");

            request.setAttribute("error","Incorrect Username or Password");
            request.getRequestDispatcher("./view/mainlogin.jsp").forward(request, response);
        }

    }

}
