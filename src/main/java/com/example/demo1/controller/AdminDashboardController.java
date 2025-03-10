package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button btnManageCourses;

    @FXML
    private Button btnManageStudents;

    @FXML
    private Button btnViewEnrollment;

    @FXML
    private Button btnAcademicRecords;

    @FXML
    private Button btnLogout;

    @FXML
    private TextArea txtTotalCourses;

    @FXML
    private TextArea txtTotalStudents;

    @FXML
    void handleManageCourses(ActionEvent event) {
        navigateTo("/com/example/demo1/view/ManageCourses.fxml");
    }

    @FXML
    void handleManageStudents(ActionEvent event) {
        navigateTo("/com/example/demo1/view/ManageStudents.fxml");
    }

    @FXML
    void handleViewEnrollment(ActionEvent event) {
        navigateTo("/com/example/demo1/view/ViewEnrollment.fxml");
    }

    @FXML
    void handleAcademicRecords(ActionEvent event) {
        navigateTo("/com/example/demo1/view/AcademicRecords.fxml");
    }

    @FXML
    void handleLogout(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to logout?");
        alert.showAndWait();
        navigateTo("/com/example/demo1/view/Login.fxml");
    }

    private void navigateTo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
