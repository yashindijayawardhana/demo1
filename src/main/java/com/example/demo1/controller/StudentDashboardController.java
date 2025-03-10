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

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crs", "root", "1234yashi");
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (student_id, name, dob, program, year, contact) VALUES (?, ?, ?, ?, ?, ?)");) {

            stmt.setString(1, studentId);
            stmt.setString(2, studentName);
            stmt.setString(3, dob);
            stmt.setString(4, program);
            stmt.setString(5, year);
            stmt.setString(6, contact);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                txtMessage.setText("Registration successful!");
            } else {
                txtMessage.setText("Registration failed.");
            }
        } catch (SQLException e) {
            txtMessage.setText("Database error: " + e.getMessage());
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
