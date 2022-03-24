package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DashboardBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Database.DashboardDAO;
import com.example.thedonorlk.Database.DonorDAO;

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

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DashboardDAO dashboardDAO;
    public void init() {
        dashboardDAO = new DashboardDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listUser(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        String bloodbank = (String)session.getAttribute("bloodbank");

        DashboardBean count = dashboardDAO.count(bloodbank);
        request.setAttribute("count", count);
        DashboardBean stock = dashboardDAO.stock(bloodbank);
        request.setAttribute("RBC_stock", stock.getRbc());
        request.setAttribute("WBC_stock", stock.getWbc());
        request.setAttribute("Platelets_stock", stock.getPlatelets());
        request.setAttribute("Plasma_stock", stock.getPlasma());
        System.out.println(stock.getRbc());
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/dashboard.jsp");
        dispatcher.forward(request, response);
    }
}