package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.PostBean;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostDAO {

    private static final String INSERT_SQL = "INSERT INTO post_timeline (Caption, Image_Video, Posted_Date, Posted_Time, Donor_ID) VALUES " +
            " (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM post_timeline p, user_donor d, user u WHERE u.ID=d.ID AND p.Donor_ID=d.ID AND p.Post_ID =? ORDER BY p.Post_ID DESC";
    private static final String SELECT_ALL = "SELECT * FROM post_timeline p, user_donor d, user u WHERE u.ID=d.ID AND p.Donor_ID=d.ID AND p.Status='Viewable' ORDER BY Post_ID DESC";
    private static final String SELECT_ALL_BY_DONOR = "SELECT * FROM post_timeline p, user_donor d, user u WHERE u.ID=d.ID AND p.Donor_ID=d.ID AND Donor_ID =? AND p.Status='Viewable' ORDER BY Post_ID DESC";
    private static final String DELETE_SQL = "DELETE FROM post_timeline WHERE Post_ID = ?";
    private static final String UPDATE_STATUS_SQL = "UPDATE post_timeline SET " +
            "Status = ? WHERE Post_ID = ?";
    private static final String UPDATE_SQL = "UPDATE post_timeline SET " +
            "Caption = ?, Image_Video = ?, Posted_Date = ?, Posted_Time = ?, " +
            "Donor_ID = ? WHERE Post_ID = ?";

    public PostDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertPost(PostBean post) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        java.sql.Time sqlTime=new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, post.getCaption());
            preparedStatement.setBlob(2, post.getImage_video());
            preparedStatement.setDate(3, sqlDate);
            preparedStatement.setTime(4, sqlTime);
            preparedStatement.setString(5, post.getDonor_id());
            //System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public PostBean selectPost(int id) {
        PostBean post = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            System.out.println("Test DAO Post");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Post_ID");
                String caption = rs.getString("Caption");
                byte[] image_video = rs.getBytes("Image_Video");
                String posted_date = rs.getString("Posted_Date");
                String posted_time = rs.getString("Posted_Time");
                String donor_id = rs.getString("Donor_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                byte[] donor_profile = rs.getBytes("Profile");
                String status = rs.getString("Status");

                post = new PostBean(id_1, caption, null, image_video, posted_date, posted_time, donor_id, donor_name, donor_profile, status);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return post;
    }

    public List < PostBean > selectAllPostsByDonor(int d_id) {
        List < PostBean > post = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_BY_DONOR);) {
            preparedStatement.setInt(1, d_id);
            //System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Post_ID");
                String caption = rs.getString("Caption");
                byte[] image_video = rs.getBytes("Image_Video");
                String posted_date = rs.getString("Posted_Date");
                String posted_time = rs.getString("Posted_Time");
                String donor_id = rs.getString("Donor_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                byte[] donor_profile = rs.getBytes("Profile");
                String status = rs.getString("Status");

                post.add(new PostBean(id, caption, null, image_video, posted_date, posted_time, donor_id, donor_name, donor_profile, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return post;
    }

    public List < PostBean > selectAllPosts() {
        List < PostBean > post = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL);) {
            //System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Post_ID");
                String caption = rs.getString("Caption");
                byte[] image_video = rs.getBytes("Image_Video");
                String posted_date = rs.getString("Posted_Date");
                String posted_time = rs.getString("Posted_Time");
                String donor_id = rs.getString("Donor_ID");
                String donor_name = rs.getString("First_Name") + " " + rs.getString("Last_Name");
                byte[] donor_profile = rs.getBytes("Profile");
                String status = rs.getString("Status");

                post.add(new PostBean(id, caption, null, image_video, posted_date, posted_time, donor_id, donor_name, donor_profile, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return post;
    }

    public boolean deletePost(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updatePostStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_STATUS_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updatePost(PostBean post) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_SQL);) {
            statement.setString(1, post.getCaption());
            statement.setBlob(2, post.getImage_video());
            statement.setString(3, post.getDate());
            statement.setString(4, post.getTime());
            statement.setString(5, post.getDonor_id());
            statement.setInt(6, post.getId());

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
