package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.NotificationDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/requestInsert")
public class BloodRequestInsert extends HttpServlet {
    //private static final long serialVersionUID = 1 L;

    private BloodRequestDAO requestDAO;
    private UserBloodBankDAO bloodBankDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        requestDAO = new BloodRequestDAO();
        bloodBankDAO = new UserBloodBankDAO();
        notificationDAO = new NotificationDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            insertRequest(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String from_bloodbank_code = request.getParameter("From_BloodBank_Code");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        String blood_group = request.getParameter("Blood_Group");
        String blood_product = request.getParameter("Blood_Product");
        String required_count = request.getParameter("Required_Count");
        String remark = request.getParameter("Remark");

        BloodRequestBean newRequest = new BloodRequestBean(0, from_bloodbank_code, bloodbank_code,
                blood_group, blood_product, required_count, remark, "request_date", "request_time", "New");

        String message = from_bloodbank_code + " is urgently requesting " + blood_group + " type " + blood_product + " blood product. " +
                "Required count is " + required_count + ". Please respond at the earliest. " +
                "#TheDonor.lk";
        NotificationBean notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(bloodbank_code), bloodBankDAO.selectIDFromBloodBankCode(from_bloodbank_code),"New Blood Request",message,"","");

        if (requestDAO.insertRequest(newRequest)) {
            notificationDAO.insertNotificaion(notification);
            response.sendRedirect("./bloodRequestSent");
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
            dispatcher.forward(request, response);
        }
    }
}