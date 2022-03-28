package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Database.*;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/violationManagement")
public class ViolationManagement extends HttpServlet {

    private PostDAO postDAO;
    private DonorDAO donorDAO;
    private ViolationDAO violationDAO;
    private NotificationDAO notificationDAO;

    public void init() {
        postDAO = new PostDAO();
        donorDAO = new DonorDAO();
        violationDAO = new ViolationDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            int notifier_id = (Integer) session.getAttribute("user_id");

            String type = request.getParameter("type");
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println(id);

            ViolationBean violationBean = violationDAO.selectViolation(id);
            int donor_id = violationDAO.selectViolation(id).getDonor_id();
            //System.out.println(donor_id);
            List<DonorBean> donor = new ArrayList<>();
            donor.add(donorDAO.selectDonor(donor_id));

            if (type.equals("Decline")) {
                String message = "Your violation report number " + id + ". " +
                        "is declined by the admin. Thank you for reporting to us.";
                NotificationBean notification = new NotificationBean(0, 0, notifier_id, "Violation Report", message, "", "");

                notificationDAO.insertNotificaionWithDonorBeanList(notification, donor);

                violationDAO.updateStatus(id, "Declined");
                response.sendRedirect("./violation");
            } else if (type.equals("Remove")) {
                String message = "Your violation report number " + id + " " +
                        "is accepted by the admin as against the community guidelines. " +
                        "Hence the post is removed. Thank you for reporting to us.";
                NotificationBean notification = new NotificationBean(0, 0, notifier_id, "Violation Report", message, "", "");

                int post_id = Integer.parseInt(request.getParameter("post_id"));
                //System.out.println(post_id);
                //postDAO.deletePost(post_id);
                postDAO.updatePostStatus(post_id, "Removed");
                violationDAO.updateStatus(id, "Removed");

                notificationDAO.insertNotificaionWithDonorBeanList(notification, donor);

                response.sendRedirect("./violation");
            }
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("violation");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }
}