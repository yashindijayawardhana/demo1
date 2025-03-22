package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import com.example.demo1.db.DBConnection;

public class studentRegisterCoursesController {

    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtStudentName;
    @FXML
    private DatePicker dpDateOfBirth;
    @FXML
    private TextField txtProgram;
    @FXML
    private ComboBox<String> cmbYear;
    @FXML
    private TextField txtContactNo;
    @FXML
    private TextArea txtMessage;
    @FXML
    private Button btnRegister;

    @FXML
    public void initialize() {
        cmbYear.getItems().addAll("1st Year", "2nd Year", "3rd Year", "4th Year");
    }

    @FXML
    private void registerStudent() {
        String studentID = txtStudentID.getText().trim();
        String studentName = txtStudentName.getText().trim();
        LocalDate dob = dpDateOfBirth.getValue();
        String program = txtProgram.getText().trim();
        String year = cmbYear.getValue();
        String contactNo = txtContactNo.getText().trim();

        if (studentID.isEmpty() || studentName.isEmpty() || dob == null || program.isEmpty() || year == null || contactNo.isEmpty()) {
            txtMessage.setText("Please fill all fields.");
            return;
        }

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO students (student_id, name, dob, program, year, contact_no) VALUES (?, ?, ?, ?, ?, ?)");) {

            ps.setString(1, studentID);
            ps.setString(2, studentName);
            ps.setDate(3, java.sql.Date.valueOf(dob));
            ps.setString(4, program);
            ps.setString(5, year);
            ps.setString(6, contactNo);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                txtMessage.setText("Student registered successfully!");
            } else {
                txtMessage.setText("Registration failed.");
            }
        } catch (SQLException e) {
            txtMessage.setText("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}