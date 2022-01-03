package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Database.CampaignDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/campaign")
public class CampaignServlet extends HttpServlet {
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
            listUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List <CampaignBean> listCampaign = campaignDAO.selectAllCampaigns();
        request.setAttribute("listCampaign", listCampaign);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/campaigns.jsp");
        dispatcher.forward(request, response);
    }
}