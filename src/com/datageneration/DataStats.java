package com.datageneration;

import java.sql.*;

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

    private Connection getConnection() {
        return connection;
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

    public int closeConnection() {
        int connectionCloseStatus = 0;
        try {
            getConnection().close();
            connectionCloseStatus = 1;
            return connectionCloseStatus;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connectionCloseStatus;
    }

    public int getRemainingRecords() {
        int numRecordsRemaining = 0;
        try {
            connect();
            String sqlString = "SELECT COUNT(tconst) FROM imdb_stats";
            PreparedStatement getRemainingRecordsStmt = getConnection().prepareStatement(sqlString);
            ResultSet getRemainingRecordsResults = getRemainingRecordsStmt.executeQuery();
            ResultSetMetaData getRemainingRecordsMetaData = getRemainingRecordsResults.getMetaData();
            while (getRemainingRecordsResults.next()) {
                numRecordsRemaining = getRemainingRecordsResults.getInt(1);
            }
            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return numRecordsRemaining;
    }

}
