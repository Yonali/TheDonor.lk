package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.BloodStockDAO;
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

@WebServlet("/bloodStock")
public class BloodStockServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodStockDAO stockDAO;
    private UserBloodBankDAO userBloodBankDAO;
    public void init() {
        stockDAO = new BloodStockDAO();
        userBloodBankDAO = new UserBloodBankDAO();
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
        String bank = request.getParameter("bank");

        List <BloodStockBean> listStock = null;
        if (bank.equals("all")) {
            listStock = stockDAO.selectAllStocks();
        } else {
            listStock = stockDAO.selectStocksByBank(bank);
        }
        request.setAttribute("listStock", listStock);
        List <UserBloodBankBean> listBloodBank = userBloodBankDAO.selectAllUsers();
        request.setAttribute("listBloodBank", listBloodBank);
        request.setAttribute("selectedBank", bank);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/stock.jsp");
        dispatcher.forward(request, response);
    }
}