package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DeferralHistoryBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.CampaignDAO;
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

@WebServlet("/donorShowDeferralHistory")
public class DonorShowDeferralHistory extends HttpServlet {

    private DonorDAO donorDAO;
    public void init() {
        donorDAO = new DonorDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            showHistory(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void showHistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        List <DeferralHistoryBean> history = donorDAO.selectDeferralHistory(id);
        request.setAttribute("history", history);
        DonorBean donor = donorDAO.selectDonor(Integer.parseInt(id));
        request.setAttribute("donor_name", donor.getFname() + " " + donor.getLname());
        request.setAttribute("donor_nic", donor.getNic());
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donorDeferralHistory.jsp");
        dispatcher.forward(request, response);
    }
}
