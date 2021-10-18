package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.UserAdminBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAdminDAO {

    private static final String INSERT_USERS_SQL = "INSERT INTO user (Username, Password, Role) VALUES " +
            " (?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,username from user where id =?";
    private static final String SELECT_ALL_USERS = "select * from user WHERE role='admin'";
    private static final String DELETE_USERS_SQL = "delete from user where id = ?";
    private static final String UPDATE_USERS_SQL = "update user set username = ? where id = ?";

    public UserAdminDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public void insertUser(UserAdminBean user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, "Test");
            preparedStatement.setString(3, "admin");
//            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public UserAdminBean selectUser(int id) {
        UserAdminBean user = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("ID");
                String username = rs.getString("Username");
                user = new UserAdminBean(id_1, username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < UserAdminBean > selectAllUsers() {
        List < UserAdminBean > users = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                users.add(new UserAdminBean(id, username));
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

    public boolean updateUser(UserAdminBean user) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getId());

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
