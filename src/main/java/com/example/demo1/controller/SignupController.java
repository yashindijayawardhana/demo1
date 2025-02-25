package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class SignupController {

    @FXML
    private TextField txtFullName;

    @FXML
    private DatePicker dpDateOfBirth;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtProgramOfStudy;

    @FXML
    private TextField txtYearOfStudy;

    @FXML
    private TextField txtStudentID;

    @FXML
    private RadioButton rbMale;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;

    @FXML
    private RadioButton rbStudent;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private Button btnSignUp;

    @FXML
    private ToggleGroup genderGroup;

    @FXML
    private ToggleGroup roleGroup;

    @FXML
    void onSignUpButtonClick(ActionEvent event) {
        String fullName = txtFullName.getText();
        String email = txtEmail.getText();
        String phone = txtPhoneNumber.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();
        String program = txtProgramOfStudy.getText();
        String year = txtYearOfStudy.getText();
        String studentID = txtStudentID.getText();
        String dob = (dpDateOfBirth.getValue() != null) ? dpDateOfBirth.getValue().toString() : "";

        String gender = "";
        if (rbMale.isSelected()) gender = "Male";
        else if (rbFemale.isSelected()) gender = "Female";
        else if (rbOther.isSelected()) gender = "Other";

        String role = "";
        if (rbStudent.isSelected()) role = "Student";
        else if (rbAdmin.isSelected()) role = "Admin";

        // Validation
        if (fullName.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() ||
                confirmPassword.isEmpty() || program.isEmpty() || year.isEmpty() || studentID.isEmpty() || dob.isEmpty()) {
            showAlert("Error", "All fields are required!", AlertType.ERROR);
            return;
        }

        if (!password.equals(confirmPassword)) {
            showAlert("Error", "Passwords do not match!", AlertType.ERROR);
            return;
        }

        if (role.isEmpty()) {
            showAlert("Error", "Please select a role!", AlertType.ERROR);
            return;
        }

        if (gender.isEmpty()) {
            showAlert("Error", "Please select your gender!", AlertType.ERROR);
            return;
        }

        // If all validations pass
        showAlert("Success", "Account created successfully!", AlertType.INFORMATION);

        // Here you can add code to insert user details into the database
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
