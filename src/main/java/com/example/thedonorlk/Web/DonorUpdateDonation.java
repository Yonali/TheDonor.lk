package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DonorDAO;
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

@WebServlet("/donorUpdateDonation")
public class DonorUpdateDonation extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonorDAO donorDAO;
    private UserBloodBankDAO bloodbankDAO;
    public void init() {
        donorDAO = new DonorDAO();
        bloodbankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donor");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String fname = request.getParameter("First_Name");
        String lname = request.getParameter("Last_Name");
        String nic = request.getParameter("NIC");
        String blood_group = "";
        String contact = request.getParameter("Contact");
        String dob = request.getParameter("DOB");
        String gender = request.getParameter("Gender");
        String status = "Normal";
        String email = request.getParameter("Email");
        String add_street = request.getParameter("Address_Street");
        String add_city = request.getParameter("Address_City");
        String bloodbank_code = request.getParameter("BloodBank_Code");
        DonorBean newDonor = new DonorBean(0, fname, lname, nic, blood_group, contact,dob, gender.equals("NULL") ? null: gender,
                email, add_street, add_city, "profile", "description", bloodbank_code.equals("NULL") ? null: bloodbank_code, status);

            if (donorDAO.updateUserDonation(newDonor)) {
                //response.sendRedirect("./donor");
                //Redirect to next page
            } else {
                request.setAttribute("error","Something went wrong, Please Try Again");

                List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
                request.setAttribute("listBloodBank", listBloodBank);
                request.setAttribute("donor_NIC", nic);
                request.setAttribute("donor_Email", email);
                DonorBean donorBean = donorDAO.selectDonorByEmail(email);
                request.setAttribute("donor", donorBean);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationNewDonor.jsp");
                dispatcher.forward(request, response);
            }
    }
}