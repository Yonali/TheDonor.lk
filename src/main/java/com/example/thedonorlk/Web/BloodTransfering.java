package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.BloodTransferBean;
import com.example.thedonorlk.Database.BloodStockDAO;
import com.example.thedonorlk.Database.BloodTransferDAO;

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
    public void init() {
        stockDAO = new BloodStockDAO();
        transferDAO = new BloodTransferDAO();
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

        if (transferDAO.insertTransfer(transfer) && stockDAO.updateStockBank(id, to_bloodbank_code)) {
            response.sendRedirect("./bloodStock?bank=" + to_bloodbank_code);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
        }
    }
}