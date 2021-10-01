package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorRegBean;
import com.example.thedonorlk.Database.DonorRegDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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

        if (pwd.length() < 8) {
            request.setAttribute("error","Password should be Minimum 8 Characters long");
            request.getRequestDispatcher("./view/DonorRegister.jsp").forward(request, response);
        } else if (!hash_pwd.equals(hash_cnfrm_pwd)) {
            request.setAttribute("error","Passwords do not match, Please try again");
            request.getRequestDispatcher("./view/DonorRegister.jsp").forward(request, response);
        } else {
            if (donorRegDAO.addDonorReg(donorRegBean)) {
                response.sendRedirect("./view/timeline.jsp");
            } else {
                System.out.println("Something went wrong, Please Try Again");
                request.setAttribute("error","Something went wrong, Please Try Again");
                request.getRequestDispatcher("./view/DonorRegister.jsp").forward(request, response);
            }
        }
    }
}
