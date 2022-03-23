package com.example.thedonorlk.Database.User;

import com.example.thedonorlk.Bean.User.UserBloodBankBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBloodBankDAO {

    private static final String INSERT_USERS_SQL = "INSERT INTO user (Username, Password, Role) " +
            "VALUES (?, ?, ?); ";
    private static final String INSERT_USERS_SQL2 = "INSERT INTO user_bloodbank (ID, Code, Name, Contact, Email, Address_Number, Address_Street, Address_City) " +
            "VALUES (?, ?, ?, ?, ?, null, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user, user_bloodbank WHERE user.id =? AND user.id=user_bloodbank.id";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user, user_bloodbank WHERE role='bloodbank' AND user.id=user_bloodbank.id";
    private static final String DELETE_USERS_SQL = "DElETE FROM user where id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET username = ? WHERE id = ?; " +
            "UPDATE user_bloodbank SET code=?, name=?, contact=?, email=?, Address_Street=?, Address_City=? WHERE id = ?;";
    private static final String UPDATE_USERS_SQL2 = "UPDATE user_bloodbank SET name=?, contact=?, Address_Street=?, Address_City=? WHERE id = ?";
    public UserBloodBankDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertUser(UserBloodBankBean user) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, "Test");
            preparedStatement.setString(3, "bloodbank");
//            System.out.println(preparedStatement);

            preparedStatement.execute();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        String sql = "select ID from user where username = ?";
        String id = "";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL2)) {
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, user.getCode());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getContact());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAdd_street());
            preparedStatement.setString(7, user.getAdd_city());
//            System.out.println(preparedStatement);

            preparedStatement.execute();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }

    public UserBloodBankBean selectUser(int id) {
        UserBloodBankBean user = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("id");
                String code = rs.getString("code");
                String username = rs.getString("username");
                String name = rs.getString("name");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String address_street = rs.getString("address_street");
                String address_city = rs.getString("address_city");
                user = new UserBloodBankBean(id_1, code, username, name, contact, email, address_street, address_city);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < UserBloodBankBean > selectAllUsers() {
        List <UserBloodBankBean> users = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String username = rs.getString("username");
                String name = rs.getString("name");
                String contact = rs.getString("contact");
                String email = rs.getString("email");
                String address_street = rs.getString("address_street");
                String address_city = rs.getString("address_city");
                users.add(new UserBloodBankBean(id, code, username, name, contact, email, address_street, address_city));
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

    public boolean updateUser(UserBloodBankBean user) throws SQLException {
        //"UPDATE user SET username = ? WHERE id = ?; " +
        //            "UPDATE user_bloodbank SET code=?, name=?, contact=?, email=?, Address_Street=?, Address_City=? WHERE id = ?;";
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getUsername());
            statement.setInt(2, user.getId());
            statement.setString(3, user.getCode());
            statement.setString(4, user.getName());
            statement.setString(5, user.getContact());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAdd_street());
            statement.setString(8, user.getAdd_city());
            statement.setInt(9, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public boolean updateBloodBank2(UserBloodBankBean user) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL2);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getContact());
            statement.setString(3, user.getAdd_street());
            statement.setString(4, user.getAdd_city());
            statement.setInt(5, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean validateUsername(UserBloodBankBean user) {
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
