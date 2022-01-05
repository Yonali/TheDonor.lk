package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.CampaignBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloodRequestDAO {

    private static final String INSERT_REQUEST_SQL = "INSERT INTO blood_request (From_BloodBank_Code, To_BloodBank_Code, Blood_Group, Blood_Product, Required_Count, Remark, Request_Date, Request_Time, Status) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_REQUEST_BY_ID = "SELECT * FROM blood_request WHERE Blood_Request_ID=? ORDER BY Blood_Request_ID DESC";
    private static final String SELECT_ALL_REQUESTS = "SELECT * FROM blood_request ORDER BY Blood_Request_ID DESC";
    private static final String DELETE_REQUEST_SQL = "DELETE FROM blood_request WHERE Blood_Request_ID=?";
    private static final String UPDATE_REQUEST_SQL = "UPDATE blood_request SET " +
            "Status = ? WHERE Blood_Request_ID = ?";
    /*private static final String UPDATE_REQUEST_SQL = "UPDATE blood_request SET " +
            "Campaign_Name = ?, Campaign_Date = ?, Start_Time = ?, End_Time = ?, " +
            "Address_Street = ?, Address_City = ?, BloodBank_Code = ? WHERE Blood_Request_ID  = ?";*/

    public BloodRequestDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertRequest(BloodRequestBean request) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Time sqlTime=new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_REQUEST_SQL)) {
            preparedStatement.setString(1, request.getFrom_bloodbank_code());
            preparedStatement.setString(2, request.getTo_bloodbank_code());
            preparedStatement.setString(3, request.getBlood_group());
            preparedStatement.setString(4, request.getBlood_product());
            preparedStatement.setString(5, request.getRequired_count());
            preparedStatement.setString(6, request.getRemark());
            preparedStatement.setDate(7, sqlDate);
            preparedStatement.setTime(8, sqlTime);
            preparedStatement.setString(9, request.getStatus());
//            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public BloodRequestBean selectRequest(int id) {
        BloodRequestBean request = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_REQUEST_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Blood_Request_ID ");
                String from_bloodbank_code = rs.getString("From_BloodBank_Code");
                String to_bloodbank_code = rs.getString("To_BloodBank_Code");
                String blood_group = rs.getString("Blood_Group");
                String blood_product = rs.getString("Blood_Product");
                String required_count = rs.getString("Required_Count");
                String remark = rs.getString("Remark");
                String request_date = rs.getString("Request_Date");
                String request_time = rs.getString("Request_Time");
                String status = rs.getString("Status");

                request = new BloodRequestBean(id_1, from_bloodbank_code, to_bloodbank_code, blood_group, blood_product,
                        required_count,remark, request_date, request_time, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return request;
    }

    public List < BloodRequestBean > selectAllRequests() {
        List < BloodRequestBean > request = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_REQUESTS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Blood_Request_ID");
                String from_bloodbank_code = rs.getString("From_BloodBank_Code");
                String to_bloodbank_code = rs.getString("To_BloodBank_Code");
                String blood_group = rs.getString("Blood_Group");
                String blood_product = rs.getString("Blood_Product");
                String required_count = rs.getString("Required_Count");
                String remark = rs.getString("Remark");
                String request_date = rs.getString("Request_Date");
                String request_time = rs.getString("Request_Time");
                String status = rs.getString("Status");

                request.add(new BloodRequestBean(id, from_bloodbank_code, to_bloodbank_code, blood_group,
                        blood_product, required_count,remark, request_date, request_time, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return request;
    }

    public boolean deleteRequest(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_REQUEST_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateRequestStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_REQUEST_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    /*public boolean updateUser(CampaignBean campaign) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_CAMPAIGN_SQL);) {
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
