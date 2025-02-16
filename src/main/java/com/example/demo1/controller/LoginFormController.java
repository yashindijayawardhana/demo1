package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField usernameField;  // For username input

    @FXML
    private PasswordField passwordField;  // For password input

    @FXML
    private Button loginButton;  // Button to trigger login

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple authentication logic
        if (username.equals("admin") && password.equals("admin123")) {
            loadDashboard("AdminDashboard.fxml", "Admin Dashboard");
        } else if (username.equals("student") && password.equals("student123")) {
            loadDashboard("StudentDashboard.fxml", "Student Dashboard");
        } else if (username.equals("faculty") && password.equals("faculty123")) {
            loadDashboard("FacultyDashboard.fxml", "Faculty Dashboard");
        } else {
            showErrorMessage("Invalid Credentials", "Username or password is incorrect.");
        }
    }

    // Function to open dashboard
    private void loadDashboard(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();

            // Close login window after successful login
            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();

        } catch (IOException e) {
            e.printStackTrace();
            showErrorMessage("Error", "Unable to load the dashboard.");
        }
    }

    // Function to show error messages
    private void showErrorMessage(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
