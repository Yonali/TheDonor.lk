package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DashboardBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DashboardDAO {

    private static final String SELECT_CAMPAIGN_BY_ID = "SELECT * FROM campaign WHERE Campaign_ID =? ORDER BY Campaign_ID DESC";

    public DashboardDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();
    private Date date = new Date();
    LocalDate today = LocalDate.now();
    //private java.sql.Date sqlDate=new java.sql.Date(date.getTime());

    public DashboardBean stock(String bloodbank) {
        int a_pos = 0;
        int a_neg = 0;
        int b_pos = 0;
        int b_neg = 0;
        int ab_pos = 0;
        int ab_neg = 0;
        int o_pos = 0;
        int o_neg = 0;

        String SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='A+' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                a_pos = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='A-' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                a_neg = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='B+' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                b_pos = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='B-' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                b_neg = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='AB+' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ab_pos = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='AB-' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ab_neg = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='O+' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                o_pos = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='O-' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                o_neg = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return new DashboardBean(a_pos, a_neg, b_pos, b_neg, ab_pos, ab_neg, o_pos, o_neg,
                0, 0, 0, 0, 0);
    }

    public DashboardBean count(String bloodbank) {
        int total_donor_count = 0;
        int new_donor_count = 0;
        int campaigns_count = 0;
        int appointments_count = 0;
        int donations_count = 0;

        String SQL = "SELECT COUNT(*) AS count FROM user_donor WHERE BloodBank_Code=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                total_donor_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM user_donor WHERE BloodBank_Code=? AND MONTH(Join_Date)=? AND YEAR(Join_Date)=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setInt(2, today.getMonthValue());
            preparedStatement.setInt(3, today.getYear());
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (rs.next()) {
                new_donor_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM campaign WHERE BloodBank_Code=? AND MONTH(Campaign_Date)=? AND YEAR(Campaign_Date)=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setInt(2, today.getMonthValue());
            preparedStatement.setInt(3, today.getYear());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                campaigns_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM appointment WHERE BloodBank_Code=? AND MONTH(Appointment_Date)=? AND YEAR(Appointment_Date)=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setInt(2, today.getMonthValue());
            preparedStatement.setInt(3, today.getYear());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                appointments_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM donation WHERE BloodBank_Code=? AND MONTH(Donation_Date)=? AND YEAR(Donation_Date)=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setInt(2, today.getMonthValue());
            preparedStatement.setInt(3, today.getYear());
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                donations_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return new DashboardBean(0, 0, 0, 0, 0, 0, 0, 0,
                total_donor_count, new_donor_count, campaigns_count, appointments_count, donations_count);
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
