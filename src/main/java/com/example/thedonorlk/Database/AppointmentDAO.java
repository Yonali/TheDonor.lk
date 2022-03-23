package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.AppointmentDonorBean;
import com.example.thedonorlk.Bean.CampaignBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointment a, user_donor d " +
            "WHERE d.ID=a.Donor_ID ORDER BY Appointment_ID DESC";
    private static final String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM appointment a, user_donor d " +
            "WHERE d.ID=a.Donor_ID AND Appointment_ID=? ORDER BY Appointment_ID DESC";
    private static final String UPDATE_APPOINTMENT_STATUS_SQL = "UPDATE appointment SET " +
            "STATUS  = ? " +
            "WHERE Appointment_ID = ?";
    /*private static final String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM appointment WHERE Appointment_ID =?";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE appointment SET " +
            "BloodBank_Code  = ?, Appointment_Time  = ?, Appointment_Date  = ? " +
            "WHERE Appointment_ID = ?";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointment WHERE Appointment_ID = ?";*/

    public AppointmentDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public List <AppointmentDonorBean > selectAllAppointments() {
        List < AppointmentDonorBean > appointment = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_APPOINTMENTS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Appointment_ID");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String appointment_time = rs.getString("Appointment_Time");
                String appointment_date = rs.getString("Appointment_Date");
                String donor_id = rs.getString("Donor_ID");
                String status = rs.getString("Status");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                String donor_contact = rs.getString("Contact");

                appointment.add(new AppointmentDonorBean(id, bloodbank_code, appointment_time, appointment_date, donor_id, status,
                        donor_name, donor_contact));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointment;
    }

    public AppointmentDonorBean selectAppointment(int id) {
        AppointmentDonorBean appointment = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_APPOINTMENT_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Appointment_ID");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String appointment_time = rs.getString("Appointment_Time");
                String appointment_date = rs.getString("Appointment_Date");
                String donor_id = rs.getString("Donor_ID");
                String status = rs.getString("Status");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                String donor_contact = rs.getString("Contact");

                appointment = new AppointmentDonorBean(id, bloodbank_code, appointment_time, appointment_date, donor_id, status,
                        donor_name, donor_contact);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointment;
    }

    public boolean updateAppointment(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_APPOINTMENT_STATUS_SQL);) {
            statement.setString(1, status);
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
