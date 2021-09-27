package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorRegBean;
import com.example.thedonorlk.Database.DonorRegDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DonorRegServlet", value = "/register")
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
        String dob = request.getParameter("dob");
        String pwd = request.getParameter("pwd");
        String cpwd = request.getParameter("cpwd");

        DonorRegBean donorRegBean = new DonorRegBean();
        donorRegBean.setFname(fname);
        donorRegBean.setLname(lname);
        donorRegBean.setEmail(email);
        donorRegBean.setDob(dob);
        donorRegBean.setPwd(DigestUtils.sha256Hex(pwd));
        donorRegBean.setCpwd(DigestUtils.sha256Hex(cpwd));

        if (donorRegDAO.addDonorreg(donorRegBean)) {
            response.sendRedirect("./view/timeline.jsp");
        } else {
            //response.sendRedirect("./view/DonorRegister.jsp");

            request.setAttribute("error","Invalid email or password");
            request.getRequestDispatcher("./view/DonorRegister.jsp").forward(request, response);
        }
    }
}
