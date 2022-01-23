package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.ProfileBean;
import com.example.thedonorlk.Database.DonorDAO;
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

@WebServlet("/donorShowProfileForm")
public class DonorShowProfileForm extends HttpServlet {

    private ProfileDAO profileDAO;
    private DonorDAO donorDAO;
    public void init() {
        profileDAO = new ProfileDAO();
        donorDAO = new DonorDAO();
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

        DonorCardBean donor = donorDAO.selectDonorCardByID(id);
        request.setAttribute("donor", donor);
        ProfileBean profile = profileDAO.viewProfile(id);
        request.setAttribute("profile", profile);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/donor/profileForm.jsp");
        dispatcher.forward(request, response);
    }
}
