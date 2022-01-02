package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Database.DatabaseConnection;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.UserBloodBankDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/donorEmailCheck")
public class DonorEmailCheck extends HttpServlet {
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
            search(request, response);
        } catch (SQLException ex) {
            /*request.setAttribute("error","Something went wrong, Please Try Again");
            RequestDispatcher dispatcher = request.getRequestDispatcher("donation");
            dispatcher.forward(request, response);*/
            //throw new ServletException(ex);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        String nic = request.getParameter("NIC");
        String email = request.getParameter("Email");

        if (checkEmail(email) == 0) {
            List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
            request.setAttribute("listBloodBank", listBloodBank);
            request.setAttribute("donor_NIC", nic);
            request.setAttribute("donor_Email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationNewDonor.jsp");
            dispatcher.forward(request, response);
        } else {
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


    private Connection con = DatabaseConnection.initializeDatabase();

    private int checkEmail(String email) {
        int count = 0;
        String SQL = "SELECT COUNT(*) AS count FROM user_donor WHERE Email =?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return count;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}