package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.BloodTransferBean;
import com.example.thedonorlk.Database.BloodRequestDAO;
import com.example.thedonorlk.Database.BloodTransferDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/bloodTransfer")
public class BloodTransferServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private BloodTransferDAO transferDAO;
    public void init() {
        transferDAO = new BloodTransferDAO();
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
        List <BloodTransferBean> listTransfer = transferDAO.selectAllRequests();
        request.setAttribute("listTransfer", listTransfer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/transfer.jsp");
        dispatcher.forward(request, response);
    }
}