package com.example.thedonorlk.Database.User;

import com.example.thedonorlk.Bean.User.UserDoctorBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ForgotPasswordDAO {

    private static final String INSERT_OTP_SQL = "INSERT INTO otp (email, otp, date, time) " +
            "VALUES (?, ?, ?, ?); ";
    private static final String INSERT_USERS_SQL2 = "INSERT INTO user_doctor (ID, First_Name, Last_Name, Contact, NIC, Email, Section, BloodBank_Code) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user, user_doctor WHERE user.id =? AND user.id=user_doctor.id";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user, user_doctor WHERE role='doctor' AND user.id=user_doctor.id";
    private static final String DELETE_USERS_SQL = "DElETE FROM user where id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET username = ? WHERE id = ?; " +
            "UPDATE user_doctor SET First_Name=?, Last_Name=?, Contact=?, NIC=?, Email=?, Section=?, BloodBank_Code=? WHERE id = ?;";
    private static final String UPDATE_USERS_SQL2 = "UPDATE user_doctor SET First_Name=?, Last_Name=?, Contact=?, NIC=? WHERE id = ?;";

    public ForgotPasswordDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean validateUsername(String email) {
        boolean status = false;

        // Initialize the database
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from user u, user_bloodbank b where u.username = ? OR b.Email = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean insertOTP(String email, String hash_otp) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_OTP_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hash_otp);

            preparedStatement.execute();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }

    public UserDoctorBean selectUser(int id) {
        UserDoctorBean user = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("id");
                String username = rs.getString("username");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String contact = rs.getString("contact");
                String nic = rs.getString("nic");
                String email = rs.getString("email");
                String section = rs.getString("section");
                String bloodbank_code = rs.getString("bloodbank_code");
                user = new UserDoctorBean(id_1, username, first_name, last_name, contact, nic, email, section, bloodbank_code);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < UserDoctorBean > selectAllUsers() {
        List <UserDoctorBean> users = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String contact = rs.getString("contact");
                String nic = rs.getString("nic");
                String email = rs.getString("email");
                String section = rs.getString("section");
                String bloodbank_code = rs.getString("bloodbank_code");
                users.add(new UserDoctorBean(id, username, first_name, last_name, contact, nic, email, section, bloodbank_code));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(UserDoctorBean user) throws SQLException {
        /*"UPDATE user SET username = ? WHERE id = ?; " +
                "UPDATE user_bloodbank SET First_Name=?, Last_Name=?, Contact=?, NIC=?, Email=?, Section=?, BloodBank_ID=? WHERE id = ?;"*/
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getId());
            statement.setString(3, user.getFirst_name());
            statement.setString(4, user.getLast_name());
            statement.setString(5, user.getContact());
            statement.setString(6, user.getNic());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getSection());
            statement.setString(9, user.getBloodbank_code());
            statement.setInt(10, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateDoctor2(UserDoctorBean user) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL2);) {
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setString(3, user.getContact());
            statement.setString(4, user.getNic());
            statement.setInt(5, user.getId());

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
