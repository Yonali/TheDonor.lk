package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.ProfileBean;
import com.example.thedonorlk.Bean.User.UserAdminBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {

    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id =?";
    private static final String UPDATE_PASSWORD_SQL = "UPDATE user SET password = ? WHERE id = ?";
    private static final String UPDATE_PROFILE_SQL = "UPDATE user SET profile = ? WHERE id = ?";

    public ProfileDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean updatePassword(int id, String password) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_PASSWORD_SQL);) {
            statement.setString(1, password);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateProfile(ProfileBean profile) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_PROFILE_SQL);) {
            statement.setBlob(1, profile.getProfile());
            statement.setString(2, profile.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public ProfileBean viewProfile(int id) {
        ProfileBean profile = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);x
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id_1 = rs.getString("ID");
                String username = rs.getString("Username");
                byte[] bytes = rs.getBytes("Profile");
                profile = new ProfileBean(id_1, username, null, bytes);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return profile;
    }

    public boolean validateUsername(UserAdminBean user) {
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
