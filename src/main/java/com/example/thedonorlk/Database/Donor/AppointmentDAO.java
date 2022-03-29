package com.example.thedonorlk.Database.Donor;

import com.example.thedonorlk.Bean.Donor.AppointmentBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO appointment (F_Name, BloodBank_Code, Appointment_Time, Appointment_Date, Donor_ID, Status) VALUES " +
            " (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointment a, user_bloodbank b " +
            "WHERE b.code=a.bloodbank_code ORDER BY Appointment_ID DESC";
    private static final String SELECT_APPOINTMENT_BY_ID = "SELECT * FROM appointment WHERE Appointment_ID =?";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE appointment SET " +
            "F_Name = ?, BloodBank_Code  = ?, Appointment_Time  = ?, Appointment_Date  = ? " +
            "WHERE Appointment_ID = ?";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM appointment WHERE Appointment_ID = ?";

    public AppointmentDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertUser(com.example.thedonorlk.Bean.AppointmentBean appointment) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setString(1, appointment.getName());
            preparedStatement.setString(2, appointment.getBloodbank_code());
            preparedStatement.setString(3, appointment.getAppointment_time());
            preparedStatement.setString(4, appointment.getAppointment_date());
            preparedStatement.setString(5, appointment.getDonor_id());
            preparedStatement.setString(6, appointment.getStatus());

//            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public List < AppointmentBean > selectAllAppointments() {
        List < AppointmentBean > appointment = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_APPOINTMENTS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Appointment_ID");
                String name = rs.getString("F_Name");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String appointment_time = rs.getString("Appointment_Time");
                String appointment_date = rs.getString("Appointment_Date");
                String donor_id = rs.getString("Donor_ID");
                String status = rs.getString("Status");
                String bloodbank_name = rs.getString("Name");
                String bloodbank_contact = rs.getString("Contact");
                String bloodbank_address_street = rs.getString("b.Address_Street");
                String bloodbank_address_city = rs.getString("b.Address_City");
                String bloodbank_email = rs.getString("Email");

                appointment.add(new AppointmentBean(id, name, bloodbank_code, appointment_time, appointment_date, donor_id, status,
                        bloodbank_name, bloodbank_contact, bloodbank_address_street, bloodbank_address_city, bloodbank_email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointment;
    }

    public com.example.thedonorlk.Bean.AppointmentBean selectAppointment(int id) {
        com.example.thedonorlk.Bean.AppointmentBean appointmentBean = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_APPOINTMENT_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Appointment_ID");
                String name = rs.getString("F_Name");
                String bloodbank_code = rs.getString("BloodBank_Code");
                String appointment_time = rs.getString("Appointment_Time");
                String appointment_date = rs.getString("Appointment_Date");
                String donor_id = rs.getString("Donor_ID");
                String status = rs.getString("Status");

                appointmentBean = new com.example.thedonorlk.Bean.AppointmentBean(id_1, name, bloodbank_code, appointment_time, appointment_date, donor_id, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointmentBean;
    }

    public boolean updateAppointment(com.example.thedonorlk.Bean.AppointmentBean appointment) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_APPOINTMENT_SQL);) {
            statement.setString(1, appointment.getName());
            statement.setString(2, appointment.getBloodbank_code());
            statement.setString(3, appointment.getAppointment_time());
            statement.setString(4, appointment.getAppointment_date());
            statement.setInt(5, appointment.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteAppointment(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_APPOINTMENT_SQL);) {
            statement.setInt(1, id);
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
