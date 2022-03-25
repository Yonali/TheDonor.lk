package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.BloodTransferBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Database.BloodStockDAO;
import com.example.thedonorlk.Database.BloodTransferDAO;
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

@WebServlet("/bloodTransfering")
public class BloodTransfering extends HttpServlet {
    private BloodStockDAO stockDAO;
    private BloodTransferDAO transferDAO;
    private UserBloodBankDAO bloodBankDAO;
    private NotificationDAO notificationDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
        transferDAO = new BloodTransferDAO();
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void insertRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        BloodStockBean whole = stockDAO.selectStock(id);

        String blood_barcode = whole.getBlood_barcode();
        String from_bloodbank_code = request.getParameter("From_Bloodbank_Code");
        String to_bloodbank_code = request.getParameter("To_Bloodbank_Code");
        String blood_group = whole.getBlood_group();
        String blood_product = whole.getBlood_product();

        BloodTransferBean transfer = new BloodTransferBean(0, blood_barcode,
                from_bloodbank_code, to_bloodbank_code, blood_group, blood_product, "", "");

        String message = from_bloodbank_code + " has transferred " + blood_group + " type " + blood_product + " blood product to you. " +
                "Thank you";
        NotificationBean notification = new NotificationBean(0, bloodBankDAO.selectIDFromBloodBankCode(to_bloodbank_code), bloodBankDAO.selectIDFromBloodBankCode(from_bloodbank_code),"Blood Transfer",message,"","");

        if (transferDAO.insertTransfer(transfer) && stockDAO.updateStockBank(id, to_bloodbank_code)) {
            notificationDAO.insertNotificaion(notification);
            /*response.sendRedirect("./bloodStock?bank=" + to_bloodbank_code);*/
            response.sendRedirect("./bloodStock?bank=all");
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
        }
    }
}