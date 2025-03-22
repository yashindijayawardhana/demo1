package com.example.demo1.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.demo1.db.DBConnection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Database Connected Successfully!");

            // Test if data is retrievable
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM courses");

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("course_id") + " | " +
                                    rs.getString("course_name") + " | " +
                                    rs.getInt("credit_hours") + " | " +
                                    rs.getString("department") + " | " +
                                    rs.getString("prerequisites") + " | " +
                                    rs.getInt("max_enrollment")
                    );
                }

                conn.close(); // Close connection
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Database Connection Failed!");
        }
    }
}
