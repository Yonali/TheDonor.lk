package com.example.thedonorlk.Web;

import com.example.thedonorlk.Bean.*;
import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DatabaseConnection;
import com.example.thedonorlk.Database.DonationDAO;
import com.example.thedonorlk.Database.DonorDAO;
import com.example.thedonorlk.Database.User.UserBloodBankDAO;

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

@WebServlet("/donationSearch")
public class DonationSearch extends HttpServlet {
    //private static final long serialVersionUID = 1 L;
    private DonorDAO donorDAO;
    private UserBloodBankDAO bloodbankDAO;
    private DonationDAO donationDAO;

    public void init() {
        donorDAO = new DonorDAO();
        bloodbankDAO = new UserBloodBankDAO();
        donationDAO = new DonationDAO();
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

        String blood_barcode = request.getParameter("Blood_Barcode");
        String nic = request.getParameter("NIC");
        String user_role = request.getParameter("User_Role");
        if (blood_barcode.equals("")) {
            //response.sendRedirect("./donation");
            if (checkNIC(nic) == 0) {
                //Redirect to new donor registration page
                List<UserBloodBankBean> listBloodBank = bloodbankDAO.selectAllUsers();
                request.setAttribute("listBloodBank", listBloodBank);
                request.setAttribute("donor_NIC", nic);
                RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationNewDonor.jsp");
                dispatcher.forward(request, response);
            } else {
                String status = checkDonorStatus(nic);

                if (status.equals("T_Deferred") || status.equals("P_Deferred")) {
                    request.setAttribute("status","Deferred");
                    request.setAttribute("deferral_history", donorDAO.selectLastDeferralHistoryByNIC(nic));

                    List <DonationBean> listDonation = donationDAO.selectAllDonationsByDonor(nic);
                    request.setAttribute("listDonation", listDonation);
                    DonorCardBean donor = donorDAO.selectDonorCard(nic);
                    request.setAttribute("donor", donor);
                    //request.setAttribute("donation_id", donation_id);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationManage.jsp");
                    dispatcher.forward(request, response);
                } else {
                    //Redirect to donation start page
                    List <DonationBean> listDonation = donationDAO.selectAllDonationsByDonor(nic);
                    request.setAttribute("listDonation", listDonation);
                    DonorCardBean donor = donorDAO.selectDonorCard(nic);
                    request.setAttribute("donor", donor);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationManage.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } else {
            //Redirect to relevant
            String status = checkDonationStatus(blood_barcode);
            String donation_id = getDonationID(blood_barcode);
            nic = getDonorNIC(blood_barcode);

            if (status.equals("New")) {
                if (user_role.equals("nurse")) {
                    request.setAttribute("status","New_Nurse");
                } else if (user_role.equals("doctor")) {
                    request.setAttribute("status","New_Doctor");
                }
            } else if (status.equals("Counselled")) {
                request.setAttribute("status","Counselled");
            } else if (status.equals("Completed")) {
                request.setAttribute("status","Completed");
            } else if (status.equals("Cancelled")) {
                request.setAttribute("status","Cancelled");
            } else if (status.equals("Deferred")) {
                request.setAttribute("status","Deferred");
                request.setAttribute("deferral_history", donorDAO.selectLastDeferralHistory(donation_id));
            }

            request.setAttribute("barcode",blood_barcode);
            List <DonationBean> listDonation = donationDAO.selectAllDonationsByDonor(nic);
            request.setAttribute("listDonation", listDonation);
            DonorCardBean donor = donorDAO.selectDonorCard(nic);
            request.setAttribute("donor", donor);
            request.setAttribute("donation_id", donation_id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("./view/non_donor/donationManage.jsp");
            dispatcher.forward(request, response);
        }
    }


    private Connection con = DatabaseConnection.initializeDatabase();

    private int checkNIC(String nic) {
        int count = 0;
        String SQL = "SELECT COUNT(*) AS count FROM user_donor WHERE Donor_NIC =?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, nic);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return count;
    }

    private String checkDonorStatus(String nic) {
        String status = "";
        String SQL = "SELECT Status FROM user_donor WHERE Donor_NIC = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, nic);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                status = rs.getString("Status");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private String checkDonationStatus(String barcode) {
        String status = "";
        String SQL = "SELECT Donation_Status FROM donation WHERE Blood_Barcode = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, barcode);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                status = rs.getString("Donation_Status");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return status;
    }

    private String getDonorNIC(String barcode) {
        String nic = "";
        String SQL = "SELECT Donor_NIC FROM donation d, user_donor ud WHERE d.Donor_ID = ud.ID AND d.Blood_Barcode = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, barcode);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                nic = rs.getString("Donor_NIC");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nic;
    }

    private String getDonationID(String barcode) {
        String id = "";
        String SQL = "SELECT Donation_ID FROM donation WHERE Blood_Barcode = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, barcode);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = rs.getString("Donation_ID");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return id;
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