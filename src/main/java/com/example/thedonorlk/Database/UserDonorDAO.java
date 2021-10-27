package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.UserBloodBankBean;
import com.example.thedonorlk.Bean.UserDonorBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDonorDAO {

    /*private static final String INSERT_USERS_SQL = "INSERT INTO user (Username, Password, Role) " +
            "VALUES (?, ?, ?); ";
    private static final String INSERT_USERS_SQL2 = "INSERT INTO user_bloodbank (ID, Code, Name, Contact, Email, Address_Number, Address_Street, Address_City) " +
            "VALUES (?, ?, ?, ?, ?, null, ?, ?)";*/
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user, user_donor WHERE user.username =? AND user.username=user_donor.email";
//    private static final String SELECT_ALL_USERS = "SELECT * FROM user, user_bloodbank WHERE role='donor' AND user.username=user_donor.email";
    /*private static final String DELETE_USERS_SQL = "DElETE FROM user where id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET username = ? WHERE id = ?; " +
            "UPDATE user_bloodbank SET code=?, name=?, contact=?, email=?, Address_Street=?, Address_City=? WHERE id = ?;";*/

    public UserDonorDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public UserDonorBean selectUser(String username1) {
        UserDonorBean user = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setString(1, username1);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("id");
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String email = rs.getString("Email");
                String contact = rs.getString("Contact");
                String gender = rs.getString("Gender");
                user = new UserDonorBean(id_1, fname, lname, email, contact, gender);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    /*public List < UserBloodBankBean > selectAllUsers() {
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
    }*/

    /*public boolean deleteUser(int id) throws SQLException {
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
