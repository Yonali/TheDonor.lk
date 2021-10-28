package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.UserAdminBean;
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

@WebServlet("/campaignInsert")
public class CampaignInsert extends HttpServlet {
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
            insertUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userAdmin");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String campaign_name = request.getParameter("Campaign_Name");
        String campaign_date = request.getParameter("Campaign_Date");
        String start_time = request.getParameter("Start_Time");
        String end_time = request.getParameter("End_Time");
        String address_number = request.getParameter("Address_Number");
        String address_street = request.getParameter("Address_Street");
        String address_city = request.getParameter("Address_City");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        CampaignBean newCampaign = new CampaignBean(0, campaign_name, campaign_date, start_time, end_time, address_number,address_street, address_city, bloodbank_code);

            if (campaignDAO.insertUser(newCampaign)) {
                response.sendRedirect("./campaign");
            }
    }
}