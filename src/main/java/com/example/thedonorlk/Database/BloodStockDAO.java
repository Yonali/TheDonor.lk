package com.example.thedonorlk.Database;

import com.example.thedonorlk.Bean.BloodStockBean;
import com.example.thedonorlk.Bean.BloodTransferBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BloodStockDAO {

    private static final String INSERT_STOCK_SQL = "INSERT INTO blood (Barcode, Blood_Product, Blood_Group, Bloodbank_Code, Collected_Date, Status) VALUES " +
            "(?, ?, ?, ?, ?, 'NOT_Processed')";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO blood (Barcode, Blood_Product, Blood_Group, Bloodbank_Code, Collected_Date, Processed_Date, Expiry_Date, Status) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_STOCK_BY_ID = "SELECT * FROM blood WHERE Blood_ID=? ORDER BY Blood_ID DESC";
    private static final String SELECT_ALL_STOCKS = "SELECT * FROM blood ORDER BY Blood_ID DESC";
    private static final String SELECT_ALL_STOCKS_BY_BANK = "SELECT * FROM blood WHERE Bloodbank_Code = ? ORDER BY Blood_ID DESC";
    private static final String UPDATE_STOCK_STATUS_SQL = "UPDATE blood SET " +
            "Status = ? WHERE Blood_ID = ?";
    private static final String UPDATE_STOCK_BANK_SQL = "UPDATE blood SET " +
            "Bloodbank_Code = ? WHERE Blood_ID = ?";
    private static final String EDIT_STOCK_STATUS_SQL = "UPDATE blood SET " +
            "Status = ?, Collected_Date = ?, Processed_Date = ?, Expiry_Date = ? WHERE Blood_ID = ?";

    public BloodStockDAO() {}

    private Connection con = DatabaseConnection.initializeDatabase();

    public boolean validate(int id) {
        boolean status = false;
        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "select * from blood where Blood_ID = ? AND Expiry_Date >= now()";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            //ps.setString(2, sqlDate + "");
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean insertStock(BloodStockBean stock) throws SQLException {
        boolean status = true;
        Date date = new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_STOCK_SQL)) {
            preparedStatement.setString(1, stock.getBlood_barcode());
            preparedStatement.setString(2, stock.getBlood_product());
            preparedStatement.setString(3, stock.getBlood_group());
            preparedStatement.setString(4, stock.getBloodbank_code());
            preparedStatement.setDate(5, sqlDate);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public boolean insertProduct(BloodStockBean stock) throws SQLException {
        boolean status = true;

        try (PreparedStatement preparedStatement = con.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, stock.getBlood_barcode());
            preparedStatement.setString(2, stock.getBlood_product());
            preparedStatement.setString(3, stock.getBlood_group());
            preparedStatement.setString(4, stock.getBloodbank_code());
            preparedStatement.setString(5, stock.getCollected_date());
            preparedStatement.setString(6, stock.getProcessed_date());
            preparedStatement.setString(7, stock.getExpiry_date());
            preparedStatement.setString(8, stock.getStatus());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            status = false;
            printSQLException(e);
        }
        return status;
    }

    public BloodStockBean selectStock(int id) {
        BloodStockBean transfer = null;
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_STOCK_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id_1 = rs.getInt("Blood_ID");
                String blood_barcode = rs.getString("Barcode");
                String blood_product = rs.getString("Blood_Product");
                String blood_group = rs.getString("Blood_Group");
                String bloodbank_code = rs.getString("Bloodbank_Code");
                String status = rs.getString("Status");
                String collected_date = rs.getString("Collected_Date");
                String processed_date = rs.getString("Processed_Date");
                String expiry_date = rs.getString("Expiry_Date");

                transfer = new BloodStockBean(id, blood_barcode, blood_product, blood_group, bloodbank_code,
                        status, collected_date, processed_date, expiry_date);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return transfer;
    }

    public List < BloodStockBean > selectAllStocks() {
        List < BloodStockBean > stock = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_STOCKS);) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Blood_ID");
                String blood_barcode = rs.getString("Barcode");
                String blood_product = rs.getString("Blood_Product");
                String blood_group = rs.getString("Blood_Group");
                String bloodbank_code = rs.getString("Bloodbank_Code");
                String status = rs.getString("Status");
                String collected_date = rs.getString("Collected_Date");
                String processed_date = rs.getString("Processed_Date");
                String expiry_date = rs.getString("Expiry_Date");

                stock.add(new BloodStockBean(id, blood_barcode, blood_product, blood_group, bloodbank_code,
                        status, collected_date, processed_date, expiry_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return stock;
    }

    public List <BloodStockBean> selectStocksByBank (String bank) {
        List < BloodStockBean > stock = new ArrayList < > ();
        try (PreparedStatement preparedStatement = con.prepareStatement(SELECT_ALL_STOCKS_BY_BANK);) {
            preparedStatement.setString(1, bank);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Blood_ID");
                String blood_barcode = rs.getString("Barcode");
                String blood_product = rs.getString("Blood_Product");
                String blood_group = rs.getString("Blood_Group");
                String bloodbank_code = rs.getString("Bloodbank_Code");
                String status = rs.getString("Status");
                String collected_date = rs.getString("Collected_Date");
                String processed_date = rs.getString("Processed_Date");
                String expiry_date = rs.getString("Expiry_Date");

                stock.add(new BloodStockBean(id, blood_barcode, blood_product, blood_group, bloodbank_code,
                        status, collected_date, processed_date, expiry_date));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return stock;
    }

    public boolean editStock(int id, String status, String col_date, String pro_date, String exp_date) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(EDIT_STOCK_STATUS_SQL);) {
            statement.setString(1, status);
            statement.setString(2, col_date);
            statement.setString(3, pro_date);
            statement.setString(4, exp_date);
            statement.setInt(5, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateStockStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_STOCK_STATUS_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean updateStockBank(int id, String bank) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_STOCK_BANK_SQL);) {
            statement.setString(1, bank);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    /*public boolean deleteRequest(int id) throws SQLException {
        boolean rowDeleted;
        try (PreparedStatement statement = con.prepareStatement(DELETE_REQUEST_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateRequestStatus(int id, String status) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_REQUEST_SQL);) {
            statement.setString(1, status);
            statement.setInt(2, id);

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }*/

    /*public boolean updateUser(CampaignBean campaign) throws SQLException {
        boolean rowUpdated;
        try (PreparedStatement statement = con.prepareStatement(UPDATE_CAMPAIGN_SQL);) {
            statement.setString(1, campaign.getName());
            statement.setString(2, campaign.getDate());
            statement.setString(3, campaign.getStart_time());
            statement.setString(4, campaign.getEnd_time());
            statement.setString(5, campaign.getAddress_street());
            statement.setString(6, campaign.getAddress_city());
            statement.setString(7, campaign.getBloodbank_code());
            statement.setInt(8, campaign.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
