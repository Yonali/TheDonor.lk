package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.EmergencyBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmergencyDAO {

    private static final String INSERT_SQL = "INSERT INTO emergency_requirement (Blood_Group,Req_Amount, Date, Time, Status, BloodBank_Code) VALUES " +
            " (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM emergency_requirement WHERE Emg_ID = ? ORDER BY Emg_ID DESC";
    private static final String SELECT_ALL = "SELECT * FROM emergency_requirement ORDER BY Emg_ID DESC";
    private static final String SELECT_ALL_EMERGENCY_BY_GROUP = "SELECT * FROM emergency_requirement WHERE Blood_Group = ? ORDER BY Emg_ID DESC";
    private static final String DELETE_SQL = "DELETE FROM emergency_requirement WHERE Emg_ID = ?";
    private static final String UPDATE_SQL = "UPDATE emergency_requirement SET " +
            "Blood_Group = ?, Status = ? " +
            "WHERE Emg_ID = ?";

    public EmergencyDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertUser(EmergencyBean emergency) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, emergency.getBlood_group());
            preparedStatement.setString(3, emergency.getDate());
            preparedStatement.setString(4, emergency.getTime());
            preparedStatement.setString(5, emergency.getStatus());
            preparedStatement.setString(6, emergency.getBloodbank_code());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public EmergencyBean selectEmergency(int id) {
        EmergencyBean emergency = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Emg_ID");
                String blood_group = rs.getString("Blood_Group");
                int req_amount = rs.getInt("Req_Amount");
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                String status = rs.getString("Status");
                String bloodbank_code = rs.getString("BloodBank_Code");

                emergency = new EmergencyBean(id, blood_group, req_amount, date, time, status, bloodbank_code);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return emergency;
    }

    public List < EmergencyBean > selectAllEmergency() {
        List < EmergencyBean > emergency = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Emg_ID");
                String blood_group = rs.getString("Blood_Group");
                int req_amount = rs.getInt("Req_Amount");
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                String status = rs.getString("Status");
                String bloodbank_code = rs.getString("BloodBank_Code");

                emergency.add(new EmergencyBean(id, blood_group, req_amount, date, time, status, bloodbank_code));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return emergency;
    }

    public List < EmergencyBean > selectEmergencyByGroup(String group) {
        List < EmergencyBean > emergency = new ArrayList <>();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_EMERGENCY_BY_GROUP);) {
            preparedStatement.setString(1, group);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Emg_ID");
                String blood_group = rs.getString("Blood_Group");
                int req_amount = rs.getInt("Req_Amount");
                String date = rs.getString("Date");
                String time = rs.getString("Time");
                String status = rs.getString("Status");
                String bloodbank_code = rs.getString("BloodBank_Code");

                emergency.add(new EmergencyBean(id, blood_group, req_amount, date, time, status, bloodbank_code));

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return emergency;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(EmergencyBean emergency) throws SQLException {
        boolean rowUpdated = false;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_SQL);) {
            statement.setString(1, emergency.getBlood_group());
            statement.setString(2, emergency.getStatus());
            statement.setInt(3, emergency.getId());

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
