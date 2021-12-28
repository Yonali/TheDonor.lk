package com.example.thedonorlk.Database.Donor;

import com.example.thedonorlk.Bean.Donor.CampaignBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampaignDAO {

    private static final String SELECT_ALL_CAMPAIGNS = "SELECT * FROM campaign c, user_bloodbank b " +
            "WHERE b.code=c.bloodbank_code";

    public CampaignDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public List < CampaignBean > selectAllCampaigns() {
        List < CampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CAMPAIGNS);) {
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
                String bloodbank_name = rs.getString("Name");
                String bloodbank_contact = rs.getString("Contact");
                String bloodbank_address_street = rs.getString("b.Address_Street");
                String bloodbank_address_city = rs.getString("b.Address_City");
                String bloodbank_email = rs.getString("Email");

                campaign.add(new CampaignBean(id, campaign_name, campaign_date,
                        start_time, end_time, address_number,address_street, address_city,
                        bloodbank_code, bloodbank_name, bloodbank_contact, bloodbank_address_street,
                        bloodbank_address_city, bloodbank_email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return campaign;
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
