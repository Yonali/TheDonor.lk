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

@WebServlet("/donorProfileUpdate")
public class DonorProfileUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonorDAO donorDAO;
    public void init() {
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
                updateDonor(request, response);
        } catch (SQLException ex) {
            /*request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donorShowProfile?id=" + id);
            dispatcher.forward(request, response);*/
            throw new ServletException(ex);
        }
    }

    private void updateDonor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        DonorBean donorBean = donorDAO.selectDonor(id);

        String fname = request.getParameter("First_Name");
        String lname = request.getParameter("Last_Name");
        String nic = donorBean.getNic();
        String blood_group = donorBean.getBlood_group();
        String contact = request.getParameter("Contact");
        String dob = donorBean.getDob();
        String gender = donorBean.getGender();
        String email = donorBean.getEmail();
        String add_street = request.getParameter("Add_Street");
        String add_city = request.getParameter("Add_City");
        String profile = donorBean.getProfile();
        String description = request.getParameter("About");
        String bloodbank_code = donorBean.getBloodbank_code();
        String status = donorBean.getStatus();

        DonorBean donor = new DonorBean(id, fname, lname, nic, blood_group, contact,dob, gender,
                email, add_street, add_city,profile,description,bloodbank_code, status);

            if (donorDAO.updateUserDonation(donor)) {
                response.sendRedirect("donorShowProfile?id=" + id);
            }
    }
}