package com.datageneration;

import java.sql.*;
import java.util.ArrayList;

public class DataStats {
//    private static String connectionString = "jdbc:mysql://imdbcapstone.cpsusfp5gisq.us-east-1.rds.amazonaws.com:3306/imdb_capstone?useSSL=false";
    private static String connectionString = "jdbc:mysql://localhost:3306/imdb_capstone?useSSL=false";
    private static String userName = "root";
    private static String password = "rootstudent";
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

    public static ArrayList<String> getNameConstsForTitle(String titleId) {
        ArrayList<String> nameConsts = new ArrayList<String>();
        try {
            connect();
            String sqlString = "SELECT nconst FROM name_stats where tconst = ?";
            PreparedStatement getIdAtIndexStmt = getConnection().prepareStatement(sqlString);
            getIdAtIndexStmt.setString(1, titleId);
            ResultSet getIdAtIndexResults = getIdAtIndexStmt.executeQuery();
            while (getIdAtIndexResults.next()) {
                nameConsts.add(getIdAtIndexResults.getString(1));
            }
            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return nameConsts;
    }

    public static int deleteIdFromDatabase(String idToDelete) {
        int numRecordsDeleted = -1;
        try {
            connect();
            String sqlString = "DELETE FROM imdb_stats WHERE tconst = ?";
            PreparedStatement deleteIdStmt = getConnection().prepareStatement(sqlString);
            deleteIdStmt.setString(1, idToDelete);
            numRecordsDeleted = deleteIdStmt.executeUpdate();
            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return numRecordsDeleted;
    }


    public static void resetDb() {
        try {
            connect();
            String truncateImdbStatsSql = "TRUNCATE TABLE imdb_stats";
            String truncateNameStatsSql = "TRUNCATE TABLE name_stats";
            String insertImdbStatsSql = "INSERT INTO imdb_stats (SELECT * FROM imdb_capstone_backup.imdb_stats)";
            String insertNameStatsSql = "INSERT INTO name_stats (SELECT * FROM imdb_capstone_backup.name_stats)";

            PreparedStatement truncateImdbStatsStatement = getConnection().prepareStatement(truncateImdbStatsSql);
            PreparedStatement truncateNameStatsStatement = getConnection().prepareStatement(truncateNameStatsSql);
            PreparedStatement insertImdbStatsStatement = getConnection().prepareStatement(insertImdbStatsSql);
            PreparedStatement insertNameStatsStatement = getConnection().prepareStatement(insertNameStatsSql);

            getConnection().setAutoCommit(false);
            truncateImdbStatsStatement.executeUpdate();
            truncateNameStatsStatement.executeUpdate();
            insertImdbStatsStatement.executeUpdate();
            insertNameStatsStatement.executeUpdate();
            getConnection().commit();
            getConnection().setAutoCommit(true);

            closeConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(DataStats.getRemainingRecords());
    }

}
