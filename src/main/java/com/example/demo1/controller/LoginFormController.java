package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginFormController {
    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private RadioButton rbStudent, rbAdmin, rbFaculty;

    @FXML
    private Button btnLogin, btnSignUp;

    @FXML
    private ToggleGroup userRole;

    @FXML
    private Label lblMessage;

    @FXML
    private void initialize() {
        // Initialize toggle group for radio buttons
        userRole = new ToggleGroup();
        rbStudent.setToggleGroup(userRole);
        rbAdmin.setToggleGroup(userRole);
        rbFaculty.setToggleGroup(userRole);
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = txtUsername.getText().trim();
        String password = txtPassword.getText().trim();
        Toggle selectedRole = userRole.getSelectedToggle();

        if (username.isEmpty() || password.isEmpty()) {
            lblMessage.setText("Username and Password cannot be empty!");
            lblMessage.setStyle("-fx-text-fill: red;");
            return;
        }

        if (selectedRole == null) {
            lblMessage.setText("Please select a role!");
            lblMessage.setStyle("-fx-text-fill: red;");
            return;
        }

        String role = ((RadioButton) selectedRole).getText();

        // Simulate authentication (Replace with database validation)
        if (username.equals("admin") && password.equals("1234") && role.equals("Admin")) {
            lblMessage.setText("Login Successful as Admin");
            lblMessage.setStyle("-fx-text-fill: green;");
            openDashboard("AdminDashboard.fxml");
        } else if (username.equals("student") && password.equals("1234") && role.equals("Student")) {
            lblMessage.setText("Login Successful as Student");
            lblMessage.setStyle("-fx-text-fill: green;");
            openDashboard("StudentDashboard.fxml");
        } else {
            lblMessage.setText("Invalid Credentials!");
            lblMessage.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void handleSignUp(ActionEvent event) {
        openDashboard("SignUpForm.fxml");
    }

    private void openDashboard(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/view/" + fxmlFile));
            AnchorPane root = loader.load();
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
            lblMessage.setText("Error loading page");
            lblMessage.setStyle("-fx-text-fill: red;");
        }
    }
}
