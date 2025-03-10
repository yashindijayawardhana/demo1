package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class EnrollmentManagementController {

    @FXML
    private TextField studentIdField;

    @FXML
    private TextField courseIdField;

    @FXML
    private TableView<?> enrollmentTable;

    @FXML
    private Button enrollStudentButton;

    @FXML
    private Button dropCourseButton;

    @FXML
    private Button viewEnrollmentButton;

    @FXML
    private Button backButton;

    @FXML
    private Button manageCoursesButton;

    @FXML
    private Button manageStudentButton;

    @FXML
    private Button academicRecordsButton;

    @FXML
    private Button logoutButton;

    @FXML
    void enrollStudent(ActionEvent event) {
        String studentId = studentIdField.getText().trim();
        String courseId = courseIdField.getText().trim();

        if (studentId.isEmpty() || courseId.isEmpty()) {
            showAlert("Error", "Both Student ID and Course ID are required.");
            return;
        }

        // Add enrollment logic here
        showAlert("Success", "Student " + studentId + " enrolled in course " + courseId + " successfully.");
    }

    @FXML
    void dropCourse(ActionEvent event) {
        String studentId = studentIdField.getText().trim();
        String courseId = courseIdField.getText().trim();

        if (studentId.isEmpty() || courseId.isEmpty()) {
            showAlert("Error", "Both Student ID and Course ID are required.");
            return;
        }

        // Add drop course logic here
        showAlert("Success", "Student " + studentId + " dropped from course " + courseId + " successfully.");
    }

    @FXML
    void viewEnrollment(ActionEvent event) {
        // Logic to display enrollment data
        showAlert("Information", "Displaying enrollment records.");
    }

    @FXML
    void navigateToManageCourses(ActionEvent event) throws IOException {
        navigateTo("/com/example/demo1/view/ManageCourses.fxml");
    }

    @FXML
    void navigateToManageStudents(ActionEvent event) throws IOException {
        navigateTo("/com/example/demo1/view/ManageStudents.fxml");
    }

    @FXML
    void navigateToAcademicRecords(ActionEvent event) throws IOException {
        navigateTo("/com/example/demo1/view/AcademicRecords.fxml");
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        navigateTo("/com/example/demo1/view/Login.fxml");
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        navigateTo("/com/example/demo1/view/MainDashboard.fxml");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void navigateTo(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();

        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
