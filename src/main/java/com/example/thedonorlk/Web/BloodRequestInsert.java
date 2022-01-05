package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.CampaignDAO;

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

    public void init() {
        requestDAO = new BloodRequestDAO();
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

        if (requestDAO.insertRequest(newRequest)) {
            response.sendRedirect("./bloodRequestSent");
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodRequestSent");
            dispatcher.forward(request, response);
        }
    }
}