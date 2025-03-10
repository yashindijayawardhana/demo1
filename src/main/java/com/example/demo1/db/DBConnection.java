package com.example.demo1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // Database credentials (change these according to your database)
    private static final String URL = "jdbc:mysql://localhost:3306/student_management"; // Database name
    private static final String USER = "root"; // MySQL username
    private static final String PASSWORD = "1234yashi"; // MySQL password

    // Method to establish a connection
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database Connection Failed: " + e.getMessage());
            return null;
        }
    }
}
