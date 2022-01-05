package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.BloodStockDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bloodProcessing")
public class BloodProcessing extends HttpServlet {
    private BloodStockDAO stockDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
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
        String bloodbank_code = request.getParameter("Bloodbank_Code");
        String blood_group = request.getParameter("Blood_Group");
        String collected_date = whole.getCollected_date();
        String processed_date = request.getParameter("Processed_Date");
        String rbc_expiry_date = request.getParameter("RBC_Expiry_Date");
        String wbc_expiry_date = request.getParameter("WBC_Expiry_Date");
        String platelets_expiry_date = request.getParameter("Platelets_Expiry_Date");
        String plasma_expiry_date = request.getParameter("Plasma_Expiry_Date");

        BloodStockBean rbc = new BloodStockBean(0, blood_barcode, "RBC",
                blood_group, bloodbank_code, "Active", collected_date, processed_date, rbc_expiry_date);
        BloodStockBean wbc = new BloodStockBean(0, blood_barcode, "WBC",
                blood_group, bloodbank_code, "Active", collected_date, processed_date, wbc_expiry_date);
        BloodStockBean plasma = new BloodStockBean(0, blood_barcode, "Plasma",
                blood_group, bloodbank_code, "Active", collected_date, processed_date, plasma_expiry_date);
        BloodStockBean platelets = new BloodStockBean(0, blood_barcode, "Platelets",
                blood_group, bloodbank_code, "Active", collected_date, processed_date, platelets_expiry_date);

        if (stockDAO.insertProduct(rbc) && stockDAO.insertProduct(wbc)
                && stockDAO.insertProduct(plasma) && stockDAO.insertProduct(platelets) && stockDAO.updateStockStatus(id, "Processed")) {
            response.sendRedirect("./bloodStock?bank=" + bloodbank_code);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
        }
    }
}