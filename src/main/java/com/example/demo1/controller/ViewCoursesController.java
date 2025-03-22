package com.example.demo1.controller;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.binding.Bindings;
import javafx.collections.transformation.FilteredList;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewCoursesController implements Initializable {

    @FXML private TableView<Course> courseTable;
    @FXML private TableColumn<Course, Integer> courseIdColumn;
    @FXML private TableColumn<Course, String> courseNameColumn;
    @FXML private TableColumn<Course, Integer> creditHoursColumn;
    @FXML private TableColumn<Course, String> departmentColumn;
    @FXML private TableColumn<Course, String> prerequisitesColumn;
    @FXML private TableColumn<Course, Integer> maxEnrollmentColumn;
    @FXML private TextField searchField;

    private ObservableList<Course> courseList = FXCollections.observableArrayList();
    private FilteredList<Course> filteredCourses; // Used for search filtering

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("🔹 Initializing ViewCoursesController...");

        // Bind columns to course attributes
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        creditHoursColumn.setCellValueFactory(new PropertyValueFactory<>("creditHours"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        prerequisitesColumn.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        maxEnrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("maxEnrollment"));

        loadCourses(); // Load courses into table

        // Enable live search
        searchField.textProperty().addListener((observable, oldValue, newValue) -> searchCourses(newValue));
    }

    private void loadCourses() {
        courseList.clear();
        String query = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            int rowCount = 0;
            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("credit_hours"),
                        rs.getString("department"),
                        rs.getString("prerequisites"),
                        rs.getInt("max_enrollment")
                );
                courseList.add(course);
                rowCount++;

                // Debugging: Print each loaded course
                System.out.println("✅ Loaded Course: " + course.getCourseName());
            }

            System.out.println("📊 Total Courses Loaded: " + rowCount);

            // Wrap the list in a FilteredList to enable searching
            filteredCourses = new FilteredList<>(courseList, p -> true);
            courseTable.setItems(filteredCourses);

        } catch (SQLException e) {
            System.out.println("❌ SQL Error: " + e.getMessage());
            showAlert("Database Error", "Failed to load courses.");
        }
    }

    private void searchCourses(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            filteredCourses.setPredicate(course -> true); // Show all if search is empty
        } else {
            String lowerKeyword = keyword.toLowerCase();
            filteredCourses.setPredicate(course ->
                    course.getCourseName().toLowerCase().contains(lowerKeyword) ||
                            course.getDepartment().toLowerCase().contains(lowerKeyword)
            );
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}