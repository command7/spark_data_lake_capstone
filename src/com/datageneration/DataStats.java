package com.datageneration;

import java.sql.Connection;

public class DataStats {
    private static String connectionString = "jdbc:mysql://localhost:3306/imdb_capstone?useSSL=false";
    private static String userName = "root";
    private static String password = "student";

    private String getConnectionString() {
        return connectionString;
    }

    private String getUserName() {
        return userName;
    }

    private String getPassword() {
        return password;
    }
}
