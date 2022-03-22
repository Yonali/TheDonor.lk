package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Bean.User.UserNurseBean;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;
import com.example.thedonorlk.Database.User.UserDoctorDAO;
import com.example.thedonorlk.Database.User.UserNurseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/nonDonorSettingUpdate")
public class NonDonorSettingUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserDoctorDAO doctorDAO;
    private UserNurseDAO nurseDAO;
    private UserBloodBankDAO bloodBankDAO;
    public void init() {
        doctorDAO = new UserDoctorDAO();
        nurseDAO = new UserNurseDAO();
        bloodBankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        try {
            if (role.equals("doctor")) {
                updateDoctor(request, response);
            } else if (role.equals("nurse")) {
                updateNurse(request, response);
            } else if (role.equals("bloodbank")) {
                updateBloodBank(request, response);
            }
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateDoctor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDoctorBean doctorBean = doctorDAO.selectUser(id);

        String username = doctorBean.getUsername();
        String first_name = request.getParameter("First_Name");
        String last_name = request.getParameter("Last_Name");
        String contact = request.getParameter("Contact");
        String nic = request.getParameter("NIC");
        String section = doctorBean.getSection();
        String bloodbank_code = doctorBean.getBloodbank_code();
        UserDoctorBean user = new UserDoctorBean(id, username, first_name, last_name, contact, nic, username, section, bloodbank_code);

            if (doctorDAO.updateDoctor2(user)) {
                response.sendRedirect("dashboard");
            }
    }

    private void updateNurse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserNurseBean nurseBean = nurseDAO.selectUser(id);

        String username = nurseBean.getUsername();
        String first_name = request.getParameter("First_Name");
        String last_name = request.getParameter("Last_Name");
        String contact = request.getParameter("Contact");
        String bloodgroup = request.getParameter("Blood_Group");
        String nic = request.getParameter("NIC");
        String section = nurseBean.getSection();
        String bloodbank_code = nurseBean.getBloodbank_code();
        UserNurseBean user = new UserNurseBean(id, username, first_name, last_name, contact, bloodgroup, nic, username, section, bloodbank_code);

        if (nurseDAO.updateNurse2(user)) {
            response.sendRedirect("dashboard");
        }
    }

    private void updateBloodBank(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserBloodBankBean bloodBankBean = bloodBankDAO.selectUser(id);

        String username = bloodBankBean.getUsername();
        String name = request.getParameter("Name");
        String email = bloodBankBean.getEmail();
        String contact = request.getParameter("Contact");
        String add_street = request.getParameter("Address_Street");
        String add_city = request.getParameter("Address_City");
        UserBloodBankBean user = new UserBloodBankBean(id, username, username, name, contact, email, add_street, add_city);

        if (bloodBankDAO.updateBloodBank2(user)) {
            response.sendRedirect("dashboard");
        }
    }
}