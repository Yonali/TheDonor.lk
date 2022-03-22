package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.DonorBean;
import com.example.thedonorlk.Bean.DonorCardBean;
import com.example.thedonorlk.Bean.NotificationBean;
import com.example.thedonorlk.Bean.ViolationBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotificationDAO {

    private static final String INSERT_SQL = "INSERT INTO notification (Notifyee_ID, Notifier_ID, Type, Message, DateTime) VALUES " +
            " (?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT * FROM notification WHERE Notifyee_ID =? ORDER BY DateTime DESC";
    private static final String SELECT_ALL = "SELECT * FROM notification ORDER BY DateTime DESC";
    private static final String COUNT_NEW_BY_ID = "SELECT COUNT(*) AS count FROM notification WHERE Notifyee_ID =? AND Status=0 ORDER BY DateTime DESC";
    //private static final String DELETE_SQL = "DELETE FROM campaign WHERE Campaign_ID = ?";
    private static final String UPDATE_SQL = "UPDATE notification SET " +
            "Status = ? WHERE Notifyee_ID = ?";

    public NotificationDAO() {
    }

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean insertNotificaion(NotificationBean notification) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Time sqlTime = new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, notification.getNotifyee_id());
            preparedStatement.setInt(2, notification.getNotifier_id());
            preparedStatement.setString(3, notification.getType());
            preparedStatement.setString(4, notification.getMessage());
            preparedStatement.setString(5, sqlDate + " " + sqlTime);
            //System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }

    public boolean insertNotificaionWithDonorBeanList(NotificationBean notification, List<DonorBean> donor) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Time sqlTime = new java.sql.Time(date.getTime());

        for (DonorBean d : donor) {
            try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
                preparedStatement.setInt(1, d.getId());
                preparedStatement.setInt(2, notification.getNotifier_id());
                preparedStatement.setString(3, notification.getType());
                preparedStatement.setString(4, notification.getMessage());
                preparedStatement.setString(5, sqlDate + " " + sqlTime);
                //System.out.println(preparedStatement);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                status = false;
                printSQLException(e);
            }
        }

        return status;
    }

    /*public boolean insertNotificaionWithDonorCard(NotificationBean notification, DonorCardBean donor) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        java.sql.Time sqlTime = new java.sql.Time(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_SQL)) {
            preparedStatement.setInt(1, donor.getId());
            preparedStatement.setInt(2, notification.getNotifier_id());
            preparedStatement.setString(3, notification.getType());
            preparedStatement.setString(4, notification.getMessage());
            preparedStatement.setString(5, sqlDate + " " + sqlTime);
            //System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }

        return status;
    }*/

    public int countNewNotificationByID(int n_id) {
        int count = 0;

        try (PreparedStatement preparedStatement = con.prepareStatement(COUNT_NEW_BY_ID)) {
            preparedStatement.setInt(1, n_id);
            //System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return count;
    }

    public List<NotificationBean> selectAllNotifications() {
        List<NotificationBean> notification = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL);) {
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int notifyee_id = rs.getInt("Notifyee_ID");
                int notifier_id = rs.getInt("Notifier_ID");
                String type = rs.getString("Type");
                String message = rs.getString("Message");
                String datetime = rs.getString("DateTime");
                String status = rs.getString("Status");

                notification.add(new NotificationBean(id, notifyee_id, notifier_id, type, message, datetime, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return notification;
    }

    public List<NotificationBean> selectByID(int n_id) {
        List<NotificationBean> notification = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, n_id);
//            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("ID");
                int notifyee_id = rs.getInt("Notifyee_ID");
                int notifier_id = rs.getInt("Notifier_ID");
                String type = rs.getString("Type");
                String message = rs.getString("Message");
                String datetime = rs.getString("DateTime");
                String status = rs.getString("Status");

                notification.add(new NotificationBean(id, notifyee_id, notifier_id, type, message, datetime, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return notification;
    }

    public boolean updateStatus(int n_id) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_SQL);) {
            statement.setInt(1, 1);
            statement.setInt(2, n_id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
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
