package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.ViolationBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.ViolationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/violationInsert")
public class ViolationInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private ViolationDAO violationDAO;
    public void init() {
        violationDAO = new ViolationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertViolation(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donorTimeline");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertViolation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int post_id = Integer.parseInt(request.getParameter("id"));
        int donor_id = Integer.parseInt(request.getParameter("donor_id"));
        String reason = request.getParameter("Reason");

        ViolationBean newViolation = new ViolationBean(0, post_id, donor_id, "", "", reason, "Pending");

            if (violationDAO.insertViolation(newViolation)) {
                response.sendRedirect("./donorTimeline");
            }
    }
}