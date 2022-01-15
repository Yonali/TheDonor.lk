package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.PostBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.PostDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/postInsert")
@MultipartConfig
public class PostInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private PostDAO postDAO;
    public void init() {
        postDAO = new PostDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertPost(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donorProfile");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertPost(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        String donor_id = String.valueOf(session.getAttribute("user_id"));
        String caption = request.getParameter("caption");

        PostBean post = new PostBean(0, caption, null, null, "", "", donor_id, "", null);

        Part filePart = request.getPart("image");
        if (filePart != null) {
            post.setImage_video(filePart.getInputStream());
        }

        if (postDAO.insertPost(post)) {
            response.sendRedirect("./donorProfile");
        }
    }
}