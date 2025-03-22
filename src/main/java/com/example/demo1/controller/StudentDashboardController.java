package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDashboardController {

    @FXML
    private TextField txtStudentId, txtStudentName, txtProgram, txtContact;
    @FXML
    private DatePicker dpDob;
    @FXML
    private ComboBox<String> cmbYear;
    @FXML
    private TextArea txtMessage;

    @FXML
    private void initialize() {
        // Initialize combo box values
        cmbYear.getItems().addAll("1", "2", "3", "4");
    }

    @FXML
    private void registerStudent() {
        String studentId = txtStudentId.getText().trim();
        String studentName = txtStudentName.getText().trim();
        String dob = (dpDob.getValue() != null) ? dpDob.getValue().toString() : "";
        String program = txtProgram.getText().trim();
        String year = (cmbYear.getValue() != null) ? cmbYear.getValue() : "";
        String contact = txtContact.getText().trim();

        if (studentId.isEmpty() || studentName.isEmpty() || dob.isEmpty() || program.isEmpty() || year.isEmpty() || contact.isEmpty()) {
            txtMessage.setText("All fields are required!");
            return;
        }

        Connection conn = null;
        PreparedStatement stmtStudents = null;
        PreparedStatement stmtDashboard = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crs", "root", "1234yashi");
            conn.setAutoCommit(false); // Start transaction

            // Insert into students table
            String sqlStudents = "INSERT INTO students (student_id, name, dob, program, year, contact) VALUES (?, ?, ?, ?, ?, ?)";
            stmtStudents = conn.prepareStatement(sqlStudents);
            stmtStudents.setString(1, studentId);
            stmtStudents.setString(2, studentName);
            stmtStudents.setString(3, dob);
            stmtStudents.setString(4, program);
            stmtStudents.setString(5, year);
            stmtStudents.setString(6, contact);
            stmtStudents.executeUpdate();

            // Insert into student_dashboard table
            String sqlDashboard = "INSERT INTO student_dashboard (student_id, name, program, year, contact) VALUES (?, ?, ?, ?, ?)";
            stmtDashboard = conn.prepareStatement(sqlDashboard);
            stmtDashboard.setString(1, studentId);
            stmtDashboard.setString(2, studentName);
            stmtDashboard.setString(3, program);
            stmtDashboard.setString(4, year);
            stmtDashboard.setString(5, contact);
            stmtDashboard.executeUpdate();

            conn.commit(); // Commit transaction
            txtMessage.setText("Registration successful!");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback in case of error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            txtMessage.setText("Database error: " + e.getMessage());
        } finally {
            try {
                if (stmtStudents != null) stmtStudents.close();
                if (stmtDashboard != null) stmtDashboard.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void navigateToDashboard() throws IOException {
        loadScene("/com/example/demo1/view/StudentDashboard.fxml");
    }

    @FXML
    private void navigateToProfile() throws IOException {
        loadScene("/com/example/demo1/view/StudentProfile.fxml");
    }

    @FXML
    private void navigateToViewCourses() throws IOException {
        loadScene("/com/example/demo1/view/ViewCourses.fxml");
    }

    private void loadScene(String fxmlPath) throws IOException {
        Stage stage = (Stage) txtStudentId.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
