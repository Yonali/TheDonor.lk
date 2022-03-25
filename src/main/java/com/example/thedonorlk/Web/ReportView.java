package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DashboardBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DashboardDAO;

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

@WebServlet("/reportView")
public class ReportView extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DashboardDAO dashboardDAO;
    public void init() {
        dashboardDAO = new DashboardDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            reportGenerate(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void reportGenerate(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        String bloodbank = (String)session.getAttribute("bloodbank");

        String from = request.getParameter("from");
        String to = request.getParameter("to");

        /*List <CampaignBean> listCampaign = campaignDAO.selectAllCampaigns();
        request.setAttribute("listCampaign", listCampaign);*/
        DashboardBean count = dashboardDAO.count(bloodbank);
        request.setAttribute("count", count);
        request.setAttribute("from", from);
        request.setAttribute("to", to);

        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/reportView.jsp");
        dispatcher.forward(request, response);
    }
}