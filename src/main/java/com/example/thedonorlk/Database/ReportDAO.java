package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.CampaignBean;
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
    private static final String SELECT_ALL_CAMPAIGNS_BY_BANK = "SELECT * FROM `campaign` WHERE BloodBank_Code=? AND Year(Campaign_Date)=? AND Month(Campaign_Date)=? AND Day(Campaign_Date)<=?";


    public ReportDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public ReportStockBean selectBloodStock(String bloodbank) {
        ReportStockBean stock = new ReportStockBean();
        List<Integer> beginning;
        List<Integer> campaigns;
        List<Integer> appointments;
        List<Integer> transfuse;
        List<Integer> transfered;

        stock.setRemaining(remainingStock(bloodbank));

        return stock;
    }

    private List<Integer> remainingStock(String bloodbank) {
        List<Integer> remaining = new ArrayList<Integer>();
        int total_remaining = 0;

        String SQL = "SELECT COUNT(*) AS count FROM blood WHERE BloodBank_Code=? " +
                "AND Blood_Group='A+' AND Status='Active'";
        try (PreparedStatement preparedStatement = con.prepareStatement(SQL);) {
            preparedStatement.setString(1, bloodbank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
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
                int count = rs.getInt("count");
                remaining.add(count);
                total_remaining += count;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        remaining.add(total_remaining);

        return remaining;
    }

    public List <ReportCampaignBean> selectAllCampaignsByBloodBank(String BloodBank) {
        List < ReportCampaignBean > campaign = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_CAMPAIGNS_BY_BANK);) {
            LocalDate localDate = LocalDate.now();
            int month = localDate.getMonthValue();
            int day = localDate.getDayOfMonth();
            int year = localDate.getYear();

            preparedStatement.setString(1, BloodBank);
            preparedStatement.setInt(2, year);
            preparedStatement.setInt(3, month);
            preparedStatement.setInt(4, day);
            ResultSet rs = preparedStatement.executeQuery();

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
