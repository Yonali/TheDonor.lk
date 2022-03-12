package com.example.thedonorlk.Web;

import Controller.PasswordEmailGenerator;
import com.example.thedonorlk.Bean.DonationBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DonationDAO;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/donorInsert")
public class DonorInsert extends HttpServlet {
    private DonorDAO donorDAO;
    private UserBloodBankDAO bloodbankDAO;
    private DonationDAO donationDAO;

    public void init() {
        donorDAO = new DonorDAO();
        bloodbankDAO = new UserBloodBankDAO();
        donationDAO = new DonationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonorDAO donorDAO = new DonorDAO();

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

        //Auto generate user password here
        PasswordEmailGenerator passwordEmailGenerator = new PasswordEmailGenerator();
        String password = passwordEmailGenerator.generatePassword();
        String hash_pwd = DigestUtils.sha256Hex(password);

        if (!donorDAO.validateEmail(email)) {
            if (donorDAO.insertDonor(newDonor, hash_pwd)) {
                //Send Email with credentials
                PasswordEmailGenerator mailDAO = new PasswordEmailGenerator();
                String message = "Dear " + fname + ",\n\n"
                        + "Your new thedonor.lk account credentials are as below.\n\n"
                        + "Email - " + email + "\n"
                        + "Password - " + password + "\n\n"
                        + "Thank you\nThedonor.lk";
                mailDAO.sendMail(email, "New Donor Account | TheDonor.lk", message);

                //Redirect to donation start page
                List <DonationBean> listDonation = donationDAO.selectAllDonationsByDonor(nic);
                request.setAttribute("listDonation", listDonation);
                DonorCardBean donor = donorDAO.selectDonorCard(nic);
                request.setAttribute("donor", donor);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationManage.jsp");
                dispatcher.forward(request, response);
            } else {
                //Redirect to same page with error msg
                request.setAttribute("error", "Something went wrong, Please Try Again");
                List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
                request.setAttribute("listBloodBank", listBloodBank);
                request.setAttribute("donor_NIC", nic);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationNewDonor.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            //Redirect to same page with error msg
            request.setAttribute("error", "Email already used, Please try again");
            List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
            request.setAttribute("listBloodBank", listBloodBank);
            request.setAttribute("donor_NIC", nic);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationNewDonor.jsp");
            dispatcher.forward(request, response);
        }

    }
}