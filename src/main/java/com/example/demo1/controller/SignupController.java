package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class SignupController {

    @FXML
    private TextField txtFullName, txtEmail, txtPhoneNumber, txtProgram, txtYear, txtStudentID;

    @FXML
    private PasswordField txtPassword, txtConfirmPassword;

    @FXML
    private DatePicker dpDateOfBirth;

    @FXML
    private RadioButton rbStudent, rbAdmin, rbMale, rbFemale, rbOther;

    @FXML
    private ToggleGroup roleGroup, genderGroup;

    @FXML
    private Button btnSignIn, btnLogin;

    @FXML
    void handleSignUp(ActionEvent event) {
        if (validateInputs()) {
            System.out.println("Registration successful!");
            navigateToLogin(event);
        }
    }

    @FXML
    void handleLogin(ActionEvent event) {
        navigateToLogin(event);
    }

    private boolean validateInputs() {
        String fullName = txtFullName.getText().trim();
        String email = txtEmail.getText().trim();
        String phone = txtPhoneNumber.getText().trim();
        String program = txtProgram.getText().trim();
        String year = txtYear.getText().trim();
        String studentID = txtStudentID.getText().trim();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || program.isEmpty() ||
                year.isEmpty() || studentID.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "All fields are required!");
            return false;
        }

        if (!Pattern.matches("^[A-Za-z]+$", fullName)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid full name!");
            return false;
        }

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid email format!");
            return false;
        }

        if (!Pattern.matches("\\d{10}$", phone)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Phone number must be 10 digits!");
            return false;
        }

        if (!password.equals(confirmPassword)) {
            showAlert(Alert.AlertType.ERROR, "Error", "Passwords do not match!");
            return false;
        }

        if (roleGroup.getSelectedToggle() == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a role!");
            return false;
        }

        if (genderGroup.getSelectedToggle() == null) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please select a gender!");
            return false;
        }

        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/view/LoginForm.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
