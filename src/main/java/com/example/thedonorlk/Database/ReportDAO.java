package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
import com.example.thedonorlk.Bean.DashboardBean;
import com.example.thedonorlk.Bean.ReportCampaignBean;
import com.example.thedonorlk.Bean.ReportStockBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportDAO {

    private static final String SELECT_ALL_CAMPAIGNS = "SELECT * FROM campaign ORDER BY Campaign_ID DESC";
    private static final String SELECT_ALL_CAMPAIGNS_BY_BANK = "SELECT * FROM `campaign` WHERE BloodBank_Code=? AND Campaign_Date BETWEEN ? AND ?";


    public ReportDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public DashboardBean count(String bloodbank, String from, String to) {
        int new_donor_count = 0;
        int campaigns_count = 0;
        int appointments_count = 0;
        int donations_count = 0;

        String SQL = "SELECT COUNT(*) AS count FROM user_donor WHERE BloodBank_Code=? AND Join_Date BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setString(2, from + " 00:00:00");
            preparedStatement.setString(3, to + " 23:59:59");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (rs.next()) {
                new_donor_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM campaign WHERE BloodBank_Code=? AND Campaign_Date BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setString(2, from + " 00:00:00");
            preparedStatement.setString(3, to + " 23:59:59");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                campaigns_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM appointment WHERE BloodBank_Code=? AND Appointment_Date BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setString(2, from + " 00:00:00");
            preparedStatement.setString(3, to + " 23:59:59");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                appointments_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        SQL = "SELECT COUNT(*) AS count FROM donation WHERE BloodBank_Code=? AND Donation_Date BETWEEN ? AND ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL)) {
            preparedStatement.setString(1, bloodbank);
            preparedStatement.setString(2, from + " 00:00:00");
            preparedStatement.setString(3, to + " 23:59:59");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                donations_count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return new DashboardBean(null, null, null, null, 0, new_donor_count, campaigns_count, appointments_count, donations_count);
    }

    public List <ReportCampaignBean> selectAllCampaignsByBloodBank(String BloodBank, String from, String to) {
        List < ReportCampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CAMPAIGNS_BY_BANK);) {
            LocalDate localDate = LocalDate.now();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            int year = localDate.getYear();

            preparedStatement.setString(1, BloodBank);
            preparedStatement.setString(2, from + " 00:00:00");
            preparedStatement.setString(3, to + " 23:59:59");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println(preparedStatement);

            while (rs.next()) {
                int id = rs.getInt("Campaign_ID");
                String campaign_name = rs.getString("Campaign_Name");
                String campaign_date = rs.getString("Campaign_Date");
                String address_street = rs.getString("Address_Street");
                String address_city = rs.getString("Address_City");

                campaign.add(new ReportCampaignBean(id, campaign_name, campaign_date, address_street, address_city, "", "", "", "", "", "", "", "", ""));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        for (int i = 0; i < campaign.size(); i++) {
            int campaign_id = campaign.get(i).getId();
            int total = 0;

            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='A+' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setA_pos(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='A-' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setA_neg(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }

            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='B+' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setB_pos(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='B-' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setB_neg(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }

            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='AB+' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setAb_pos(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='AB-' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setAb_neg(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }

            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='O+' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setO_pos(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            try (PreparedStatement preparedStatement = con.prepareStatement("SELECT COUNT(DISTINCT Donation_ID) AS count FROM donation d, blood b WHERE " +
                    "Campaign_ID=? AND b.Blood_Group='O-' AND d.Blood_Barcode=b.Barcode");) {
                preparedStatement.setInt(1, campaign_id);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    campaign.get(i).setO_neg(rs.getString("count"));
                    total += Integer.parseInt(rs.getString("count"));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }

            campaign.get(i).setTotal(String.valueOf(total));
        }

        return campaign;
    }

    /*public ReportStockBean selectBloodStock(String bloodbank, String from, String to) {
        ReportStockBean stock = new ReportStockBean();
        stock.setRemaining(remainingStock(bloodbank));

        return stock;
    }

    private List<Integer> remainingStock(String bloodbank) {
        List<Integer> remaining = new ArrayList<Integer>();
        int total_remaining = 0;
        int a_pos = 0;
        int a_neg = 0;
        int b_pos = 0;
        int b_neg = 0;
        int ab_pos = 0;
        int ab_neg = 0;
        int o_pos = 0;
        int o_neg = 0;

        String SQL = "SELECT Blood_Group, COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Status='Active' GROUP BY Blood_Group";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int count = rs.getInt("count");
                total_remaining += count;
                switch (rs.getString("Blood_Group")) {
                    case "A+":
                        a_pos += count;
                        break;
                    case "A-":
                        a_neg += count;
                        break;
                    case "B+":
                        b_pos += count;
                        break;
                    case "B-":
                        b_neg += count;
                        break;
                    case "AB+":
                        ab_pos += count;
                        break;
                    case "AB-":
                        ab_neg += count;
                        break;
                    case "O+":
                        o_pos += count;
                        break;
                    case "O-":
                        o_neg += count;
                        break;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        remaining.add(a_pos); remaining.add(a_neg); remaining.add(b_pos);remaining.add(b_neg);
        remaining.add(ab_pos); remaining.add(ab_neg); remaining.add(o_pos);remaining.add(o_neg);
        remaining.add(total_remaining);

        return remaining;
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
