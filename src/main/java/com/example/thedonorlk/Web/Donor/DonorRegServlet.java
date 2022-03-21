package com.example.thedonorlk.Web.Donor;

import com.example.thedonorlk.Bean.Donor.DonorRegBean;
import com.example.thedonorlk.Database.Donor.DonorRegDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


@WebServlet("/register")
public class DonorRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DonorRegDAO donorRegDAO = new DonorRegDAO();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String pwd = request.getParameter("pwd");
        String cnfrm_pwd = request.getParameter("cnfrm_pwd");
        String hash_pwd = DigestUtils.sha256Hex(pwd);
        String hash_cnfrm_pwd = DigestUtils.sha256Hex(cnfrm_pwd);

        DonorRegBean donorRegBean = new DonorRegBean();
        donorRegBean.setFname(fname);
        donorRegBean.setLname(lname);
        donorRegBean.setEmail(email);
        donorRegBean.setContact(contact);
        donorRegBean.setDob(dob);
        donorRegBean.setGender(gender);
        donorRegBean.setPwd(hash_pwd);
        donorRegBean.setCnfrm_pwd(hash_cnfrm_pwd);

        LocalDate today = LocalDate.now(); // Today's date here
        Period p = Period.between(LocalDate.parse(dob), today);

        // Now access the values as below
        System.out.println(p.getDays());
        System.out.println(p.getMonths());
        System.out.println(p.getYears());

//        int age = p.getYears();
//        System.out.println(age);

        if (pwd.length() < 8) {
            request.setAttribute("error", "Password should be Minimum 8 Characters long");
            request.getRequestDispatcher("./DonorRegister.jsp").forward(request, response);
        } else if (!hash_pwd.equals(hash_cnfrm_pwd)) {
            request.setAttribute("error", "Passwords do not match, Please try again");
            request.getRequestDispatcher("./DonorRegister.jsp").forward(request, response);
        } else if(p.getYears() < 18) {
            request.setAttribute("error", "Error msg here. Age<18");
            request.getRequestDispatcher("./DonorRegister.jsp").forward(request, response);
        } else {
            if (!donorRegDAO.validateEmail(email)) {
                if (donorRegDAO.addDonorReg(donorRegBean)) {
                    /*HttpSession session = request.getSession();
                    session.setAttribute("username",donorRegBean.getEmail());
                    session.setAttribute("role", "donor");

                    UserDonorDAO userDAO = new UserDonorDAO();
                    UserDonorBean userBean = userDAO.selectUser(donorRegBean.getEmail());
                    session.setAttribute("name", userBean.getFname() + " " + userBean.getLname());*/

                    response.sendRedirect("./login.jsp");
                } else {
                    request.setAttribute("error", "Something went wrong, Please Try Again");
                    request.getRequestDispatcher("./DonorRegister.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "Email already registered, Please try Login");
                request.getRequestDispatcher("./DonorRegister.jsp").forward(request, response);
            }

        }




    }
}