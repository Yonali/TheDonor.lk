package com.example.thedonorlk.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initializeDatabase() {

//        String dbDriver = "com.mysql.cj.jdbc.Driver";
//        String dbURL = "jdbc:mysql://localhost:3306/thedonor?allowMultiQueries=true";
//        String dbUsername = "root";
//        String dbPassword = "";

        String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbURL = "jdbc:mysql://db-mysql-blr1-43373-do-user-11092198-0.b.db.ondigitalocean.com:25060/defaultdb?allowMultiQueries=true";
        String dbUsername = "doadmin";
        String dbPassword = "ZV0PyoOWFTbze1op";

        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
