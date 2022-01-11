package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.ViolationBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.ViolationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/violation")
public class ViolationServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private ViolationDAO violationDAO;
    public void init() {
        violationDAO = new ViolationDAO();
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
        List <ViolationBean> listViolations = violationDAO.selectAllViolation();
        request.setAttribute("listViolations", listViolations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/violationReport.jsp");
        dispatcher.forward(request, response);
    }
}