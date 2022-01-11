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

    public List < ViolationBean > selectAllViolation() {
        List < ViolationBean > violation = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int post_id = rs.getInt("Post_ID");
                int donor_id = rs.getInt("Donor_ID");
                String date = rs.getString("Reported_Date");
                String time = rs.getString("Reported_Time");
                String reason = rs.getString("Reason");
                String status = rs.getString("Status");

                violation.add(new ViolationBean(id, post_id, donor_id, date, time, reason,status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return violation;
    }

    public boolean updateStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

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
