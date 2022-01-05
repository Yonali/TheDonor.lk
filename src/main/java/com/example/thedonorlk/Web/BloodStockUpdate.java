package com.example.thedonorlk.Web;

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

@WebServlet("/bloodStockUpdate")
public class BloodStockUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodStockDAO stockDAO;

    public void init() {
        stockDAO = new BloodStockDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateStock(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=all");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateStock(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");
        String bank = request.getParameter("bank");

        if (stockDAO.updateStockStatus(id, status)) {
            response.sendRedirect("./bloodStock?bank=" + bank);
        } else {
            request.setAttribute("error", "Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("bloodStock?bank=" + bank);
            dispatcher.forward(request, response);
        }
    }
}