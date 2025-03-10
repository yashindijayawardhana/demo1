package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AcademicRecordsController {

    @FXML
    private TextField txtStudentID;

    @FXML
    private TableView<?> tableAcademicRecords;

    @FXML
    private Button btnSearch, btnViewDetails, btnBack;

    @FXML
    private void searchStudent(ActionEvent event) {
        String studentID = txtStudentID.getText().trim();
        if (studentID.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Student ID cannot be empty!");
            return;
        }

        // TODO: Add database search logic here
        showAlert(Alert.AlertType.INFORMATION, "Search", "Searching for Student ID: " + studentID);
    }

    @FXML
    private void viewDetails(ActionEvent event) {
        // TODO: Implement logic to display detailed academic records
        showAlert(Alert.AlertType.INFORMATION, "Details", "Displaying student details...");
    }

    @FXML
    private void navigateBack(ActionEvent event) {
        navigateToPage("../view/MainMenu.fxml", "Main Menu");
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateToPage(String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            AnchorPane root = loader.load();
            Stage stage = (Stage) txtStudentID.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
        } catch (IOException e) {
            showAlert(Alert.AlertType.ERROR, "Navigation Error", "Failed to load the page: " + e.getMessage());
        }
    }
}
