package com.example.thedonorlk.Database.User;

import com.example.thedonorlk.Bean.User.UserNurseBean;
import com.example.thedonorlk.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserNurseDAO {

    private static final String INSERT_USERS_SQL = "INSERT INTO user (Username, Password, Role) " +
            "VALUES (?, ?, ?); ";
    private static final String INSERT_USERS_SQL2 = "INSERT INTO user_nurse (ID, First_Name, Last_Name, Contact, NIC, Email, Section, BloodBank_Code) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user, user_nurse WHERE user.id =? AND user.id=user_nurse.id";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user, user_nurse WHERE role='nurse' AND user.id=user_nurse.id";
    private static final String DELETE_USERS_SQL = "DElETE FROM user where id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET username = ? WHERE id = ?; " +
            "UPDATE user_nurse SET First_Name=?, Last_Name=?, Contact=?, NIC=?, Email=?, Section=?, BloodBank_Code=? WHERE id = ?;";

    public UserNurseDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertUser(UserNurseBean user) throws SQLException {
        boolean status = true;
        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, "Test");
            preparedStatement.setString(3, "nurse");
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
            preparedStatement.setString(2, user.getFirst_name());
            preparedStatement.setString(3, user.getLast_name());
            preparedStatement.setString(4, user.getContact());
            preparedStatement.setString(5, user.getNic());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getSection());
            preparedStatement.setString(8, user.getBloodbank_code());
//            System.out.println(preparedStatement);

            preparedStatement.execute();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }

    public UserNurseBean selectUser(int id) {
        UserNurseBean user = null;
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
                user = new UserNurseBean(id_1, username, first_name, last_name, contact, nic, email, section, bloodbank_code);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List < UserNurseBean > selectAllUsers() {
        List <UserNurseBean> users = new ArrayList < > ();
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
                users.add(new UserNurseBean(id, username, first_name, last_name, contact, nic, email, section, bloodbank_code));
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

    public boolean updateUser(UserNurseBean user) throws SQLException {
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

    public boolean validateUsername(UserNurseBean user) {
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
