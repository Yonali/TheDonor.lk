package com.example.thedonorlk.Web;

import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.UserAdminDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/campaignDelete")
public class CampaignDelete extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private CampaignDAO campaignDAO;
    public void init() {
        campaignDAO = new CampaignDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            deleteUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("campaign");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        campaignDAO.deleteUser(id);
        response.sendRedirect("./campaign");
    }
}