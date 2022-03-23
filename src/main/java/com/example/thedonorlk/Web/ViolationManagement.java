package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.DeferralHistoryBean;
import com.example.thedonorlk.Database.*;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/violationManagement")
public class ViolationManagement extends HttpServlet {

    private PostDAO postDAO;
    private ViolationDAO violationDAO;
    public void init() {
        postDAO = new PostDAO();
        violationDAO = new ViolationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String type = request.getParameter("type");
            int id = Integer.parseInt(request.getParameter("id"));

            if (type.equals("Decline")) {
                violationDAO.updateStatus(id, "Declined");
                response.sendRedirect("./violation");
            } else if (type.equals("Remove")) {
                int post_id = Integer.parseInt(request.getParameter("post_id"));
                System.out.println(post_id);
                postDAO.deletePost(post_id);
                violationDAO.updateStatus(id, "Removed");
                response.sendRedirect("./violation");
            }
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("violation");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }
}