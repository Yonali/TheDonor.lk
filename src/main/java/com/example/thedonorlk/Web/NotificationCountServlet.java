package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.NotificationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/notificationCount")
public class NotificationCountServlet extends HttpServlet {

    private NotificationDAO notificationDAO;
    public void init() {
        notificationDAO = new NotificationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = (Integer) session.getAttribute("user_id");

        NotificationDAO notificationDAO = new NotificationDAO();
        PrintWriter out = response.getWriter();

        int count = 0;

        count = notificationDAO.countNewNotificationByID(id);

        out.print(count);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
