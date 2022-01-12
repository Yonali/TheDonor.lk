package com.example.thedonorlk.Database.Donor;

import com.example.thedonorlk.Bean.Donor.EmergencyBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmergencyDAO {
    private static final String SELECT_ALL_EMERGENCY = "SELECT * FROM emergency_requirement e, user_bloodbank b " +
            "WHERE b.code=e.bloodbank_code";



    public EmergencyDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public List<EmergencyBean> selectAllEmergency(){
        List <EmergencyBean > emergency = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_EMERGENCY);) {
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("Emg_ID");
                String blood_group = rs.getString("Blood_Group");
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                String status = rs.getString("Status");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String bloodbank_name = rs.getString("Name");
                String bloodbank_contact = rs.getString("Contact");
                String bloodbank_address_street = rs.getString("b.Address_Street");
                String bloodbank_address_city = rs.getString("b.Address_City");
                String bloodbank_email = rs.getString("Email");


                emergency.add(new EmergencyBean(id, blood_group, date, time, status,
                        bloodbank_code, bloodbank_name, bloodbank_contact, bloodbank_address_street,
                        bloodbank_address_city, bloodbank_email));
            }
        }catch (SQLException e) {
            printSQLException(e);
        }
        return emergency;
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
