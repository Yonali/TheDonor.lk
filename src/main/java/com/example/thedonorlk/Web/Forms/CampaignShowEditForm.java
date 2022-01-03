package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.CampaignDAO;
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

@WebServlet("/campaignShowEditForm")
public class CampaignShowEditForm extends HttpServlet {

    private CampaignDAO campaignDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        campaignDAO = new CampaignDAO();
        bloodbankDAO = new UserBloodBankDAO();
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
        CampaignBean campaign = campaignDAO.selectCampaign(id);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/campaignsForm.jsp");
        request.setAttribute("user", campaign);
        dispatcher.forward(request, response);
    }
}
