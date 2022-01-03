package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Database.DonationDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/donation")
public class DonationServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonationDAO donationDAO;
    public void init() {
        donationDAO = new DonationDAO();
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
        List <DonationBean> listDonation = donationDAO.selectAllDonations();
        request.setAttribute("listDonation", listDonation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donations.jsp");
        dispatcher.forward(request, response);
    }
}