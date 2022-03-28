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

@WebServlet("/bloodProcessingShowForm")
public class BloodProcessingShowForm extends HttpServlet {
    public void init() {
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
        /*int id = Integer.parseInt(request.getParameter("id"));
        CampaignBean campaign = campaignDAO.selectCampaign(id);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();*/
        request.setAttribute("id", request.getParameter("id"));
        /*request.setAttribute("bloodBarcode", request.getParameter("barcode"));
        request.setAttribute("colDate", request.getParameter("colDate"));*/
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/stockProcessingForm.jsp");
        dispatcher.forward(request, response);
    }
}
