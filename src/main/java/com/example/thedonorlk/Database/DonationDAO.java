package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DonationBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DonationDAO {

    private static final String INSERT_DONATION_SQL = "INSERT INTO donation " +
            "(Donation_Status, Donation_Date, Donation_Time, BloodBank_Code, " +
            "Nurse_ID, Doctor_ID, Donor_ID, Blood_Barcode) " +
            "VALUES ('New', ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_DONATION_BY_ID = "SELECT * FROM donation d, user_donor ud WHERE d.Donor_ID = ud.ID AND d.Donation_ID =? ORDER BY d.Donation_ID DESC";
    private static final String SELECT_ALL_DONATIONS = "SELECT * FROM donation d, user_donor ud WHERE d.Donor_ID = ud.ID ORDER BY d.Donation_ID DESC";
    private static final String SELECT_DONATION_BY_DONOR = "SELECT * FROM donation d, user_donor ud WHERE d.Donor_ID = ud.ID AND ud.Donor_NIC =? ORDER BY d.Donation_ID DESC";



    private static final String UPDATE_DONATION_STATUS_SQL = "UPDATE donation SET " +
            "Donation_Status = ?  WHERE Donation_ID = ?";
    private static final String UPDATE_DONATION_DOCTOR_SQL = "UPDATE donation SET " +
            "Doctor_ID = ?  WHERE Donation_ID = ?";

    private static final String UPDATE_DONOR_STATUS_SQL = "UPDATE user_donor SET " +
            "Status = ? WHERE ID = ?";
    /*private static final String DELETE_CAMPAIGN_SQL = "DELETE FROM campaign WHERE Campaign_ID = ?";
      private static final String UPDATE_DONATION_BLOOD_SQL = "UPDATE donation SET " +
            "Blood_ID = ?  WHERE Donation_ID = ?"; */

    public DonationDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertDonation(DonationBean donation) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Time sqlTime=new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_DONATION_SQL)) {
            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setTime(2, sqlTime);
            preparedStatement.setString(3, donation.getBloodbank_code());
            preparedStatement.setString(4, donation.getNurse_id());
            preparedStatement.setString(5, donation.getDoctor_id());
            preparedStatement.setString(6, donation.getDonor_id());
            preparedStatement.setString(7, donation.getBlood_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public DonationBean selectDonation(int id) {
        DonationBean donation = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_DONATION_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Donation_ID");
                String status = rs.getString("Donation_Status");
                String date = rs.getString("Donation_Date");
                String time = rs.getString("Donation_Time");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String nurse_id = rs.getString("Nurse_ID");
                String doctor_id = rs.getString("Doctor_ID");
                String donor_id = rs.getString("Donor_ID");
                String blood_id = rs.getString("Blood_Barcode");
                String campaign_id = rs.getString("Campaign_ID");
                String appointment_id = rs.getString("Appointment_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                String donor_nic = rs.getString("Donor_NIC");

                donation = new DonationBean(id_1, status, date, time, bloodbank_code, nurse_id, doctor_id,
                        donor_id, blood_id, campaign_id, appointment_id, donor_name, donor_nic);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donation;
    }

    public List < DonationBean > selectAllDonationsByDonor(String nic) {
        List < DonationBean > donation = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_DONATION_BY_DONOR);) {
            preparedStatement.setString(1, nic);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Donation_ID");
                String status = rs.getString("Donation_Status");
                String date = rs.getString("Donation_Date");
                String time = rs.getString("Donation_Time");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String nurse_id = rs.getString("Nurse_ID");
                String doctor_id = rs.getString("Doctor_ID");
                String donor_id = rs.getString("Donor_ID");
                String blood_id = rs.getString("Blood_Barcode");
                String campaign_id = rs.getString("Campaign_ID");
                String appointment_id = rs.getString("Appointment_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                String donor_nic = rs.getString("Donor_NIC");

                donation.add(new DonationBean(id, status, date, time, bloodbank_code, nurse_id, doctor_id,
                        donor_id, blood_id, campaign_id, appointment_id, donor_name, donor_nic));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donation;
    }

    public List < DonationBean > selectAllDonations() {
        List < DonationBean > donation = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DONATIONS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Donation_ID");
                String status = rs.getString("Donation_Status");
                String date = rs.getString("Donation_Date");
                String time = rs.getString("Donation_Time");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String nurse_id = rs.getString("Nurse_ID");
                String doctor_id = rs.getString("Doctor_ID");
                String donor_id = rs.getString("Donor_ID");
                String blood_id = rs.getString("Blood_Barcode");
                String campaign_id = rs.getString("Campaign_ID");
                String appointment_id = rs.getString("Appointment_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                String donor_nic = rs.getString("Donor_NIC");

                donation.add(new DonationBean(id, status, date, time, bloodbank_code, nurse_id, doctor_id,
                        donor_id, blood_id, campaign_id, appointment_id, donor_name, donor_nic));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donation;
    }

    /*public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_CAMPAIGN_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }*/

    public boolean updateStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_DONATION_STATUS_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateDonorStatus(String id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_DONOR_STATUS_SQL);) {
            statement.setString(1, status);
            statement.setString(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateDoctor(int id, int doc_id) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_DONATION_DOCTOR_SQL);) {
            statement.setInt(1, doc_id);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
