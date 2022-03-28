package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAO {

    private static final String INSERT_CAMPAIGN_SQL = "INSERT INTO campaign (Campaign_Name, Campaign_Date, Start_Time, End_Time, Address_Street, Address_City, BloodBank_Code) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_CAMPAIGN_BY_ID = "SELECT * FROM campaign WHERE Campaign_ID =? ORDER BY Campaign_ID DESC";
    private static final String SELECT_ALL_CAMPAIGNS = "SELECT * FROM campaign ORDER BY Campaign_ID DESC";
    private static final String SELECT_ALL_CAMPAIGNS_BY_BANK = "SELECT * FROM campaign WHERE BloodBank_Code = ? ORDER BY Campaign_ID DESC";
    private static final String DELETE_CAMPAIGN_SQL = "DELETE FROM campaign WHERE Campaign_ID = ?";
    private static final String UPDATE_CAMPAIGN_SQL = "UPDATE campaign SET " +
            "Campaign_Name = ?, Campaign_Date = ?, Start_Time = ?, End_Time = ?, " +
            "Address_Street = ?, Address_City = ?, BloodBank_Code = ? WHERE Campaign_ID = ?";

    public CampaignDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertUser(CampaignBean campaign) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_CAMPAIGN_SQL)) {
            preparedStatement.setString(1, campaign.getName());
            preparedStatement.setString(2, campaign.getDate());
            preparedStatement.setString(3, campaign.getStart_time());
            preparedStatement.setString(4, campaign.getEnd_time());
            preparedStatement.setString(5, campaign.getAddress_street());
            preparedStatement.setString(6, campaign.getAddress_city());
            preparedStatement.setString(7, campaign.getBloodbank_code());
//            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public CampaignBean selectCampaign(int id) {
        CampaignBean campaign = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_CAMPAIGN_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Campaign_ID");
                String campaign_name = rs.getString("Campaign_Name");
                String campaign_date = rs.getString("Campaign_Date");
                String start_time = rs.getString("Start_Time");
                String end_time = rs.getString("End_Time");
                String address_number = rs.getString("Address_Number");
                String address_street = rs.getString("Address_Street");
                String address_city = rs.getString("Address_City");
                String bloodbank_code = rs.getString("BloodBank_Code");

                campaign = new CampaignBean(id_1, campaign_name, campaign_date, start_time, end_time, address_number,address_street, address_city, bloodbank_code);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return campaign;
    }

    public List < CampaignBean > selectAllCampaigns() {
        List < CampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CAMPAIGNS);) {
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

    public List < CampaignBean > selectAllCampaignsByBloodBank(String BloodBank) {
        List < CampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CAMPAIGNS_BY_BANK);) {
            preparedStatement.setString(1, BloodBank);
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

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_CAMPAIGN_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(CampaignBean campaign) throws SQLException {
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
