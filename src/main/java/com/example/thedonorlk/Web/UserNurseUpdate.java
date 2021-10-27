package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Bean.UserDoctorBean;
import com.example.thedonorlk.Bean.UserNurseBean;
import com.example.thedonorlk.Database.UserBloodBankDAO;
import com.example.thedonorlk.Database.UserDoctorDAO;
import com.example.thedonorlk.Database.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userNurseUpdate")
public class UserNurseUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserNurseDAO userDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        userDAO = new UserNurseDAO();
        bloodbankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error"," Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userNurse");
            dispatcher.forward(request, response);
//            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String contact = request.getParameter("contact");
        String nic = request.getParameter("nic");
        String section = request.getParameter("section");
        String bloodbank_code = request.getParameter("bloodbank_code");
        UserNurseBean user = new UserNurseBean(id, username, first_name, last_name, contact, nic, username, section, bloodbank_code);

        if (!userDAO.validateUsername(user)) {
            if (userDAO.updateUser(user)) {
                response.sendRedirect("./userNurse");
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            UserNurseBean existingUser = userDAO.selectUser(id);
            request.setAttribute("user", existingUser);
            List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
            request.setAttribute("listBloodBank", listBloodBank);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/nurseForm.jsp");
            dispatcher.forward(request, response);
        }
    }
}