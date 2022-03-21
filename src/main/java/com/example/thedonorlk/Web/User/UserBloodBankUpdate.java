package com.example.thedonorlk.Web.User;

import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userBloodBankUpdate")
public class UserBloodBankUpdate extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private UserBloodBankDAO userBloodBankDAO;
    public void init() {
        userBloodBankDAO = new UserBloodBankDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateUser(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userBloodBank");
            dispatcher.forward(request, response);
            //throw new ServletException(ex);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String bg = request.getParameter("bg");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String add_street = request.getParameter("add_street");
        String add_city = request.getParameter("add_city");
        UserBloodBankBean user = new UserBloodBankBean(id, username, username, name, bg, contact, email, add_street, add_city);

        if (!userBloodBankDAO.validateUsername(user)) {
            if (userBloodBankDAO.updateUser(user)) {
                response.sendRedirect("./userBloodBank");
            } else {
                request.setAttribute("error","Something went wrong, Please Try Again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("userBloodBank");
                dispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("error","Username already registered, Try a new username");
            UserBloodBankBean existingUser = userBloodBankDAO.selectUser(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/bloodbankForm.jsp");
            request.setAttribute("user", existingUser);
            dispatcher.forward(request, response);
        }
    }
}