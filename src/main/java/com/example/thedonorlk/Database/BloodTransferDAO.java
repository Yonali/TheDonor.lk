package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.BloodRequestBean;
import com.example.thedonorlk.Bean.BloodTransferBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloodTransferDAO {

    private static final String INSERT_TRANSFER_SQL = "INSERT INTO blood_transfer (Blood_Barcode, From_BloodBank_Code, To_BloodBank_Code, Blood_Group, Blood_Product, Transfer_Date, Transfer_Time) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_TRANSFER_BY_ID = "SELECT * FROM blood_transfer WHERE Blood_Transfer_ID=? ORDER BY Blood_Transfer_ID DESC";
    private static final String SELECT_ALL_TRANSFERS = "SELECT * FROM blood_transfer ORDER BY Blood_Transfer_ID DESC";
    /*private static final String DELETE_TRANSFER_SQL = "DELETE FROM blood_request WHERE Blood_Request_ID=?";
    private static final String UPDATE_TRANSFER_SQL = "UPDATE blood_request SET " +
            "Status = ? WHERE Blood_Request_ID = ?";*/
    /*private static final String UPDATE_REQUEST_SQL = "UPDATE blood_request SET " +
            "Campaign_Name = ?, Campaign_Date = ?, Start_Time = ?, End_Time = ?, " +
            "Address_Street = ?, Address_City = ?, BloodBank_Code = ? WHERE Blood_Request_ID  = ?";*/

    public BloodTransferDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertTransfer(BloodTransferBean transfer) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Time sqlTime=new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_TRANSFER_SQL)) {
            preparedStatement.setString(1, transfer.getBlood_barcode());
            preparedStatement.setString(2, transfer.getFrom_bloodbank_code());
            preparedStatement.setString(3, transfer.getTo_bloodbank_code());
            preparedStatement.setString(4, transfer.getBlood_group());
            preparedStatement.setString(5, transfer.getBlood_product());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.setTime(7, sqlTime);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public BloodTransferBean selectRequest(int id) {
        BloodTransferBean transfer = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_TRANSFER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Blood_Transfer_ID");
                String blood_barcode = rs.getString("Blood_Barcode");
                String from_bloodbank_code = rs.getString("From_BloodBank_Code");
                String to_bloodbank_code = rs.getString("To_BloodBank_Code");
                String blood_group = rs.getString("Blood_Group");
                String blood_product = rs.getString("Blood_Product");
                String transfer_date = rs.getString("Transfer_Date");
                String transfer_time = rs.getString("Transfer_Time");

                transfer = new BloodTransferBean(id_1, blood_barcode, from_bloodbank_code, to_bloodbank_code, blood_group, blood_product,
                        transfer_date, transfer_time);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return transfer;
    }

    public List < BloodTransferBean > selectAllRequests() {
        List < BloodTransferBean > transfer = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_TRANSFERS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Blood_Transfer_ID");
                String blood_barcode = rs.getString("Blood_Barcode");
                String from_bloodbank_code = rs.getString("From_BloodBank_Code");
                String to_bloodbank_code = rs.getString("To_BloodBank_Code");
                String blood_group = rs.getString("Blood_Group");
                String blood_product = rs.getString("Blood_Product");
                String transfer_date = rs.getString("Transfer_Date");
                String transfer_time = rs.getString("Transfer_Time");

                transfer.add(new BloodTransferBean(id, blood_barcode, from_bloodbank_code, to_bloodbank_code, blood_group, blood_product,
                        transfer_date, transfer_time));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return transfer;
    }

    /*public boolean deleteRequest(int id) throws SQLException {
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
    }*/

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
