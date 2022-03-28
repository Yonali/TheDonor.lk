package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Database.CampaignDAO;
import com.example.thedonorlk.Database.DonorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/donorUpdate")
public class DonorUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonorDAO donorDAO;
    public void init() {
        donorDAO = new DonorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            /*request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donor");
            dispatcher.forward(request, response);*/
            throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fname = request.getParameter("First_Name");
        String lname = request.getParameter("Last_Name");
        String nic = request.getParameter("NIC");
        String blood_group = request.getParameter("Blood_Group");
        String contact = request.getParameter("Contact");
        String dob = request.getParameter("DOB");
        String gender = request.getParameter("Gender");
        String status = request.getParameter("Status");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        DonorBean newDonor = new DonorBean(id, fname, lname, nic, blood_group.equals("NULL") ? null: blood_group, contact,dob, gender.equals("NULL") ? null: gender,
                "email", "add_street", "add_city", "profile", "description", bloodbank_code.equals("NULL") ? null: bloodbank_code, status);

            if (donorDAO.updateUser(newDonor)) {
                response.sendRedirect("./donor");
            }/* else {
                request.setAttribute("error","Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("donor");
                dispatcher.forward(request, response);
            }*/
    }
}