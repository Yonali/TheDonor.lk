package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.EmergencyBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.EmergencyDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/emergency")
public class EmergencyServlet extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private EmergencyDAO emergencyDAO;
    public void init() {
        emergencyDAO = new EmergencyDAO();
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
        String group = request.getParameter("group");

        List <EmergencyBean> listEmergency = null;

            if (group.equals("all")) {
                listEmergency = emergencyDAO.selectAllEmergency();
            } else {
                listEmergency = emergencyDAO.selectEmergencyByGroup(group);

        }


        request.setAttribute("listEmergency", listEmergency);
        List <EmergencyBean> listGroup = emergencyDAO.selectAllEmergency();
        request.setAttribute("listGroup", listGroup);
        request.setAttribute("selectedGroup", group);
        RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/emergency.jsp");
        dispatcher.forward(request, response);
    }
}