package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/donationShowDeferralForm")
public class DonationShowDeferralForm extends HttpServlet {


    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showForm(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int donor_id = Integer.parseInt(request.getParameter("donor_id"));

        request.setAttribute("id", id);
        request.setAttribute("donor_id", donor_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationDeferralForm.jsp");
        dispatcher.forward(request, response);
    }
}
