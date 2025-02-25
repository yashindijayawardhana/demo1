package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class LoginFormController {

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private RadioButton rbStudent;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbFaculty;

    @FXML
    void onLoginButtonClick(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String role = "";

        if (rbStudent.isSelected()) {
            role = "Student";
        } else if (rbAdmin.isSelected()) {
            role = "Admin";
        } else if (rbFaculty.isSelected()) {
            role = "Faculty";
        } else {
            showAlert("Error", "Please select a role", Alert.AlertType.ERROR);
            return;
        }

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Username or Password cannot be empty", Alert.AlertType.ERROR);
            return;
        }

        // Dummy login validation (Replace with database verification)
        if (isValidLogin(username, password, role)) {
            showAlert("Success", "Login Successful as " + role, Alert.AlertType.INFORMATION);
            // Navigate to the dashboard or next scene
        } else {
            showAlert("Error", "Invalid Username or Password", Alert.AlertType.ERROR);
        }
    }

    private boolean isValidLogin(String username, String password, String role) {
        // Replace this with actual database verification
        if (role.equals("Admin") && username.equals("admin") && password.equals("admin123")) {
            return true;
        } else if (role.equals("Student") && username.equals("student") && password.equals("stu123")) {
            return true;
        } else if (role.equals("Faculty") && username.equals("faculty") && password.equals("fac123")) {
            return true;
        }
        return false;
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
