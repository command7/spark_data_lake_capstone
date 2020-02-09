package com.datageneration;

import java.sql.*;

public class DataStats {
    private static String connectionString = "jdbc:mysql://localhost:3306/imdb_capstone?useSSL=false";
    private static String userName = "root";
    private static String password = "student";
    private static Connection connection;

    private static String getConnectionString() {
        return connectionString;
    }

    private static String getUserName() {
        return userName;
    }

    private static String getPassword() {
        return password;
    }

    private static Connection getConnection() {
        return connection;
    }

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(connectionString, getUserName(), getPassword());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int closeConnection() {
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

    public static int getRemainingRecords() {
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

    public static String getIdAtIndex(int idIndex) {
        String idAtIndex = "";
        try {
            connect();
            String sqlString = "SELECT tconst FROM imdb_stats LIMIT 1 OFFSET ?";
            PreparedStatement getIdAtIndexStmt = getConnection().prepareStatement(sqlString);
            getIdAtIndexStmt.setInt(1, idIndex);
            ResultSet getIdAtIndexResults = getIdAtIndexStmt.executeQuery();
            while (getIdAtIndexResults.next()) {
                idAtIndex = getIdAtIndexResults.getString(1);
            }
            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return idAtIndex;
    }

    public static void deleteIdFromDatabase(String idToDelete) {
        try {
            connect();
            String sqlString = "DELETE FROM imdb_stats WHERE tconst = ?";
            PreparedStatement deleteIdStmt = getConnection().prepareStatement(sqlString);
            deleteIdStmt.setString(1, idToDelete);
            int deleteStatus = deleteIdStmt.executeUpdate();
            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(DataStats.getRemainingRecords());
        System.out.println(DataStats.getIdAtIndex(0));
    }

}
