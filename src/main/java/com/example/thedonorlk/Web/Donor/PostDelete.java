package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.PostDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/postDelete")
public class PostDelete extends HttpServlet {

    private PostDAO postDAO;
    public void init() {
        postDAO = new PostDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            deletePost(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donorProfile");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        postDAO.deletePost(id);
        response.sendRedirect("./donorProfile");
    }
}