package com.example.demo1.dao;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public List<Admin> getAllAdmins() {
        List<Admin> adminList = new ArrayList<>();
        String query = "SELECT * FROM admin";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int adminId = resultSet.getInt("admin_id");
                String fullName = resultSet.getString("full_name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String password = resultSet.getString("password");

                Admin admin = new Admin(adminId, fullName, email, phoneNumber, password);
                adminList.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminList;
    }
}
