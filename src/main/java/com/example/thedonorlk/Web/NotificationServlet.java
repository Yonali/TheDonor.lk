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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/notification")
public class NotificationServlet extends HttpServlet {

    private NotificationDAO notificationDAO;
    public void init() {
        notificationDAO = new NotificationDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showEditForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession(false);
        int id = (Integer) session.getAttribute("user_id");

        List<NotificationBean> notifications = notificationDAO.selectByID(id);
        request.setAttribute("notifications", notifications);
        if (notificationDAO.updateStatus(id)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/notification.jsp");
            dispatcher.forward(request, response);
        }

    }
}
