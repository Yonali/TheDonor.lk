package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.PostBean;
import com.example.thedonorlk.Bean.ProfileBean;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.PostDAO;
import com.example.thedonorlk.Database.ProfileDAO;

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

@WebServlet("/violationPostView")
public class ViolationPostViewServlet extends HttpServlet {

    private PostDAO postDAO;
    public void init() {
        postDAO = new PostDAO();
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
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Test View Servlet");

        PostBean posts = postDAO.selectPost(id);
        //System.out.println(posts);
        request.setAttribute("posts", posts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/violationReportPostView.jsp");
        dispatcher.forward(request, response);
    }
}
