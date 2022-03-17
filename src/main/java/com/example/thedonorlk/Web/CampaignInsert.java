package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.NotificationDAO;

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

@WebServlet("/campaignInsert")
public class CampaignInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private CampaignDAO campaignDAO;
    private DonorDAO donorDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        campaignDAO = new CampaignDAO();
        donorDAO = new DonorDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertCampaign(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("campaign");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertCampaign(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        int notifier_id = (Integer) session.getAttribute("user_id");

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
                String message = "An upcoming blood donation camp '" + campaign_name +
                        "' is organized by your nearest blood bank '" + bloodbank_code + "'. " +
                        "Date - " + campaign_date + ", Time - " + start_time + " to " + end_time + ". " +
                        "At - " + address_street + ", " + address_city + ". " +
                        "Please come and join with us to save lives";

                List<DonorBean> donor = donorDAO.selectAllDonorsByBloodbank(bloodbank_code);
                NotificationBean notification = new NotificationBean(0,0, notifier_id,"Campaign",message,"","");
                notificationDAO.insertNotificaionWithDonorBeanList(notification, donor);

                request.setAttribute("SendToDonorList", donor);
                request.setAttribute("Message", message);

                RequestDispatcher dispatcher = request.getRequestDispatcher("campaign");
                dispatcher.forward(request, response);
            }
    }
}