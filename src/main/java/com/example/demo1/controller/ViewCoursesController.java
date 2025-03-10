package com.example.demo1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewCoursesController {

    @FXML
    private TextField searchField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Course> coursesTable;

    @FXML
    private TableColumn<Object, Object> courseIdColumn;

    @FXML
    private TableColumn<Object, Object> courseTitleColumn;

    @FXML
    private TableColumn<Object, Object> creditsColumn;

    @FXML
    private TableColumn<Object, Object> courseDetailsColumn;

    @FXML
    private Button dashboardButton;

    @FXML
    private Button registerButton;

    private ObservableList<Course> courseList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Setting up table columns
        courseIdColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        creditsColumn.setCellValueFactory(new PropertyValueFactory<>("credits"));
        courseDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("courseDetails"));

        // Sample data (Replace this with database retrieval)
        courseList.add(new Course("CS101", "Introduction to Programming", 3, "Learn Java basics"));
        courseList.add(new Course("DB202", "Database Management", 4, "SQL and database design"));
        courseList.add(new Course("NET303", "Networking Essentials", 3, "Fundamentals of computer networks"));

        coursesTable.setItems(courseList);
    }

    @FXML
    private void searchCourses(ActionEvent event) {
        String keyword = searchField.getText().toLowerCase();
        if (keyword.isEmpty()) {
            coursesTable.setItems(courseList);
        } else {
            ObservableList<Course> filteredList = FXCollections.observableArrayList();
            for (Course course : courseList) {
                if (course.getCourseTitle().toLowerCase().contains(keyword) ||
                        course.getCourseId().toLowerCase().contains(keyword)) {
                    filteredList.add(course);
                }
            }
            coursesTable.setItems(filteredList);
        }
    }

    @FXML
    private void navigateToDashboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/view/StudentDashboard.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) dashboardButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void navigateToRegisterCourses(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/view/StudentRegisterCourses.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) registerButton.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static class Course {
        private String courseId;
        private String courseTitle;
        private int credits;
        private String courseDetails;

        public Course(String courseId, String courseTitle, int credits, String courseDetails) {
            this.courseId = courseId;
            this.courseTitle = courseTitle;
            this.credits = credits;
            this.courseDetails = courseDetails;
        }

        public String getCourseId() {
            return courseId;
        }

        public String getCourseTitle() {
            return courseTitle;
        }

        public int getCredits() {
            return credits;
        }

        public String getCourseDetails() {
            return courseDetails;
        }
    }
}
