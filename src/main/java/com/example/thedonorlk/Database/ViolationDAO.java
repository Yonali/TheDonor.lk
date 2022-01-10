package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.ViolationBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViolationDAO {

    private static final String INSERT_SQL = "INSERT INTO post_reports (Post_ID, Donor_ID, Reported_Date, Reported_Time, Reason, Status) VALUES " +
            " (?, ?, ?, ?, ?, 'Pending')";
    //private static final String SELECT_BY_ID = "SELECT * FROM post_reports WHERE Campaign_ID =? ORDER BY Campaign_ID DESC";
    private static final String SELECT_ALL = "SELECT * FROM post_reports ORDER BY Post_ID DESC";
    //private static final String DELETE_SQL = "DELETE FROM campaign WHERE Campaign_ID = ?";
    private static final String UPDATE_SQL = "UPDATE post_reports SET " +
            "Status = ? WHERE ID = ?";

    public ViolationDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertViolation(ViolationBean violation) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Time sqlTime=new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, violation.getPost_id());
            preparedStatement.setInt(2, violation.getDonor_id());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setTime(4, sqlTime);
            preparedStatement.setString(5, violation.getReason());
            //System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public List < CampaignBean > selectAllViolation() {
        List < CampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Campaign_ID");
                String campaign_name = rs.getString("Campaign_Name");
                String campaign_date = rs.getString("Campaign_Date");
                String start_time = rs.getString("Start_Time");
                String end_time = rs.getString("End_Time");
                String address_number = rs.getString("Address_Number");
                String address_street = rs.getString("Address_Street");
                String address_city = rs.getString("Address_City");
                String bloodbank_code = rs.getString("BloodBank_Code");

                campaign.add(new CampaignBean(id, campaign_name, campaign_date, start_time, end_time, address_number,address_street, address_city, bloodbank_code));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return campaign;
    }

    public boolean updateViolation(CampaignBean campaign) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_SQL);) {
            statement.setString(1, campaign.getName());
            statement.setString(2, campaign.getDate());
            statement.setString(3, campaign.getStart_time());
            statement.setString(4, campaign.getEnd_time());
            statement.setString(5, campaign.getAddress_street());
            statement.setString(6, campaign.getAddress_city());
            statement.setString(7, campaign.getBloodbank_code());
            statement.setInt(8, campaign.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    /*public boolean validateUsername(UserAdminBean user) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user where username = ? AND id != ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setInt(2, user.getId());
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }*/

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
