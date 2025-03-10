package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class ManageCoursesController {

    @FXML
    private TableView<?> coursesTable;

    @FXML
    private TextField searchField;

    @FXML
    private Button btnAddCourse, btnEditCourse, btnDeleteCourse, btnSearch, btnBack;

    @FXML
    void handleAddCourse(ActionEvent event) {
        showAlert("Add Course", "Course added successfully!");
    }

    @FXML
    void handleEditCourse(ActionEvent event) {
        showAlert("Edit Course", "Course details updated successfully!");
    }

    @FXML
    void handleDeleteCourse(ActionEvent event) {
        showAlert("Delete Course", "Course deleted successfully!");
    }

    @FXML
    void handleSearchCourse(ActionEvent event) {
        if (searchField.getText().trim().isEmpty()) {
            showAlert("Validation Error", "Search field cannot be empty!");
            return;
        }
        showAlert("Search Course", "Searching for: " + searchField.getText());
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        navigateTo(event, "/com/example/demo1/view/AdminDashboard.fxml");
    }

    private void navigateTo(ActionEvent event, String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
