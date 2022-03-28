package com.example.thedonorlk.Database.User;

import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForgotPasswordDAO {

    private static final String INSERT_OTP_SQL = "INSERT INTO otp (email, otp, DateTime) " +
            "VALUES (?, ?, ?); ";
    private static final String SELECT_USER_ID = "SELECT ID FROM user_bloodbank WHERE email = ? " +
            "UNION SELECT ID FROM user WHERE username = ?";
    private static final String DELETE_SQL = "DELETE FROM otp WHERE email = ?";

    public ForgotPasswordDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean validateUsername(String email) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user u, user_bloodbank b where u.username = ? OR b.Email = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, email);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean validateOTP(String email, String otp) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from otp where email = ? AND otp = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, otp);

            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean insertOTP(String email, String hash_otp) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Time sqlTime = new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_OTP_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hash_otp);
            preparedStatement.setString(3, sqlDate + " " + sqlTime);

            preparedStatement.execute();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }

    public int selectUserID(String email) {
        int id = 0;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_ID);) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = rs.getInt("ID");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return id;
    }

    public boolean deleteOTPRecord(String email) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_SQL);) {
            statement.setString(1, email);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
