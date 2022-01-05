package com.example.thedonorlk.Web.Forms;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Database.BloodStockDAO;
import com.example.thedonorlk.Database.CampaignDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodShowEditForm")
public class BloodShowEditForm extends HttpServlet {
    private BloodStockDAO stockDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
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
        /*CampaignBean campaign = campaignDAO.selectCampaign(id);
        List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();*/
        BloodStockBean stock = stockDAO.selectStock(id);
        request.setAttribute("stock", stock);
        request.setAttribute("id", id);
        /*request.setAttribute("bloodBarcode", request.getParameter("barcode"));
        request.setAttribute("colDate", request.getParameter("colDate"));*/
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/stockForm.jsp");
        dispatcher.forward(request, response);
    }
}
