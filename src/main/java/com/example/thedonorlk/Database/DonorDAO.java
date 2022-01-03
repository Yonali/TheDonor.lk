package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.Donor.DonorRegBean;
import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Database.DatabaseConnection;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {

    private static final String INSERT_DONOR_SQL = "INSERT INTO user_donor (ID, First_Name, Last_Name, " +
            "Donor_NIC, Contact, DOB, Gender, Email, Address_Street, Address_City, BloodBank_Code, Status) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?, 'Normal')";
    private static final String SELECT_DONOR_BY_ID = "SELECT * FROM user_donor WHERE ID =?";
    private static final String SELECT_DONOR_BY_EMAIL = "SELECT * FROM user_donor WHERE Email =?";
    private static final String SELECT_ALL_DONORS = "SELECT * FROM user_donor";
    /*private static final String DELETE_DONOR_SQL = "DELETE FROM campaign WHERE Campaign_ID = ?";*/
    private static final String UPDATE_DONOR_SQL = "UPDATE user_donor SET " +
            "First_Name = ?, Last_Name = ?, Donor_NIC = ?, Blood_Group = ?, " +
            "Contact = ?, DOB = ?, Gender = ?, Status = ?, bloodbank_code = ? WHERE ID = ?";
    private static final String UPDATE_DONOR_SQL_ALL = "UPDATE user_donor SET " +
            "First_Name = ?, Last_Name = ?, Donor_NIC = ?, Blood_Group = ?, " +
            "Contact = ?, DOB = ?, Gender = ?, Status = ?, bloodbank_code = ?, " +
            "Address_Street = ?, Address_City = ?, Status = ? WHERE Email = ?";

    public DonorDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    boolean status = true;
    public boolean insertDonor(DonorBean donorBean){
        String id = createUser(donorBean.getEmail(), generatePassword());

        try{
            PreparedStatement ps = con.prepareStatement(INSERT_DONOR_SQL);
            ps.setString(1,id);
            ps.setString(2,donorBean.getFname());
            ps.setString(3,donorBean.getLname());
            ps.setString(4,donorBean.getNic());
            ps.setString(5,donorBean.getContact());
            ps.setString(6,donorBean.getDob());
            ps.setString(7,donorBean.getGender());
            ps.setString(8,donorBean.getEmail());
            ps.setString(9,donorBean.getAdd_street());
            ps.setString(10,donorBean.getAdd_city());
            ps.setString(11,donorBean.getBloodbank_code());

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        return status;
    }

    private String createUser(String email, String pwd) {
        String id = "0";

        String sql = "INSERT INTO user (Username, Password, Role) VALUES (?,?,'donor')";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pwd);

            ps.execute();
        } catch (SQLException e){
            status = false;
            e.printStackTrace();
        }
        sql = "select ID from user where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getString("ID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    //Auto generate user password here
    //Send email to the user with the password
    private String generatePassword() {
        String pass = "123456789";
        String hash_pwd = DigestUtils.sha256Hex(pass);

        return pass;
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    public DonorBean selectDonor(int id) {
        DonorBean donor = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_DONOR_BY_ID);) {
            preparedStatement.setInt(1, id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("ID");
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String nic = rs.getString("Donor_NIC");
                String blood_group = rs.getString("Blood_Group");
                String contact = rs.getString("Contact");
                String dob = rs.getString("DOB");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");
                String add_street = rs.getString("Address_Street");
                String add_city = rs.getString("Address_City");
                String profile = rs.getString("Profile_Picture");
                String description = rs.getString("About_Description");
                String bloodbank_code = rs.getString("bloodbank_code");
                String status = rs.getString("Status");

                donor = new DonorBean(id_1, fname, lname, nic, blood_group, contact,dob, gender,
                        email, add_street, add_city,profile,description,bloodbank_code, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donor;
    }

    public DonorBean selectDonorByEmail(String e_mail) {
        DonorBean donor = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_DONOR_BY_EMAIL);) {
            preparedStatement.setString(1, e_mail);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("ID");
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String nic = rs.getString("Donor_NIC");
                String blood_group = rs.getString("Blood_Group");
                String contact = rs.getString("Contact");
                String dob = rs.getString("DOB");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");
                String add_street = rs.getString("Address_Street");
                String add_city = rs.getString("Address_City");
                String profile = rs.getString("Profile_Picture");
                String description = rs.getString("About_Description");
                String bloodbank_code = rs.getString("bloodbank_code");
                String status = rs.getString("Status");

                donor = new DonorBean(id_1, fname, lname, nic, blood_group, contact,dob, gender,
                        email, add_street, add_city,profile,description,bloodbank_code, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donor;
    }

    public List < DonorBean > selectAllDonors() {
        List < DonorBean > donor = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_DONORS);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("ID");
                String fname = rs.getString("First_Name");
                String lname = rs.getString("Last_Name");
                String nic = rs.getString("Donor_NIC");
                String blood_group = rs.getString("Blood_Group");
                String contact = rs.getString("Contact");
                String dob = rs.getString("DOB");
                String gender = rs.getString("Gender");
                String email = rs.getString("Email");
                String add_street = rs.getString("Address_Street");
                String add_city = rs.getString("Address_City");
                String profile = rs.getString("Profile_Picture");
                String description = rs.getString("About_Description");
                String bloodbank_code = rs.getString("bloodbank_code");
                String status = rs.getString("Status");

                donor.add(new DonorBean(id_1, fname, lname, nic, blood_group, contact,dob, gender,
                        email, add_street, add_city,profile,description,bloodbank_code, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return donor;
    }

    /*public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_DONOR_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }*/

    public boolean updateUser(DonorBean donor) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_DONOR_SQL);) {
            statement.setString(1, donor.getFname());
            statement.setString(2, donor.getLname());
            statement.setString(3, donor.getNic());
            statement.setString(4, donor.getBlood_group());
            statement.setString(5, donor.getContact());
            statement.setString(6, donor.getDob());
            statement.setString(7, donor.getGender());
            statement.setString(8, donor.getStatus());
            statement.setString(9, donor.getBloodbank_code());
            statement.setInt(10, donor.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateUserDonation(DonorBean donor) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_DONOR_SQL_ALL);) {
            statement.setString(1, donor.getFname());
            statement.setString(2, donor.getLname());
            statement.setString(3, donor.getNic());
            statement.setString(4, donor.getBlood_group());
            statement.setString(5, donor.getContact());
            statement.setString(6, donor.getDob());
            statement.setString(7, donor.getGender());
            statement.setString(8, donor.getStatus());
            statement.setString(9, donor.getBloodbank_code());
            statement.setString(10, donor.getAdd_street());
            statement.setString(11, donor.getAdd_city());
            statement.setString(12, donor.getStatus());
            statement.setString(13, donor.getEmail());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean validateEmail(String email) {
        boolean status = false;

        String sql = "select * from user where username = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
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
