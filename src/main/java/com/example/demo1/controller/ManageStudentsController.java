package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ManageStudentsController {

    @FXML
    private TableView<Student> tblStudents;
    @FXML
    private TableColumn<Object, Object> colStudentID;
    @FXML
    private TableColumn<Object, Object> colName;
    @FXML
    private TableColumn<Object, Object> colCourse;
    @FXML
    private TableColumn<Object, Object> colEnrollmentDate;
    @FXML
    private TextField txtSearch;

    @FXML
    private void initialize() {
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCourse.setCellValueFactory(new PropertyValueFactory<>("course"));
        colEnrollmentDate.setCellValueFactory(new PropertyValueFactory<>("enrollmentDate"));
    }

    @FXML
    private void onSearchStudent() {
        String keyword = txtSearch.getText().trim();
        if (keyword.isEmpty()) {
            showAlert("Validation Error", "Search field cannot be empty", Alert.AlertType.ERROR);
            return;
        }
        // Implement search logic here
    }

    @FXML
    private void onAddStudent() {
        // Implement adding student logic
    }

    @FXML
    private void onEditStudent() {
        // Implement edit student logic
    }

    @FXML
    private void onRemoveStudent() {
        // Implement remove student logic
    }

    @FXML
    private void onBack() {
        navigateTo("/com/example/demo1/view/MainMenu.fxml");
    }

    @FXML
    private void onLogout() {
        navigateTo("/com/example/demo1/view/Login.fxml");
    }

    private void navigateTo(String fxmlPath) {
        try {
            Stage stage = (Stage) tblStudents.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private class Student {
    }
}
