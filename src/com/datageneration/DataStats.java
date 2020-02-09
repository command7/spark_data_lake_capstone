package com.datageneration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataStats {
    private static String connectionString = "jdbc:mysql://localhost:3306/imdb_capstone?useSSL=false";
    private static String userName = "root";
    private static String password = "student";
    private static Connection connection;

    private String getConnectionString() {
        return connectionString;
    }

    private String getUserName() {
        return userName;
    }

    private String getPassword() {
        return password;
    }

    public Connection connect() {
        try {
            connection = DriverManager.getConnection(connectionString, getUserName(), getPassword());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
