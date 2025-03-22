package com.example.demo1.dao;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                courses.add(new Course(
                        resultSet.getInt("course_id"),  // Now correctly getting an integer
                        resultSet.getString("course_name"),
                        resultSet.getInt("credit_hours"),
                        resultSet.getString("department"),
                        resultSet.getString("prerequisites"),
                        resultSet.getInt("max_enrollment")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public void addCourse(Course course) {
        String query = "INSERT INTO courses (course_name, credit_hours, department, prerequisites, max_enrollment) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCreditHours());
            preparedStatement.setString(3, course.getDepartment());
            preparedStatement.setString(4, course.getPrerequisites());
            preparedStatement.setInt(5, course.getMaxEnrollment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) {
        String query = "UPDATE courses SET course_name=?, credit_hours=?, department=?, prerequisites=?, max_enrollment=? WHERE course_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCreditHours());
            preparedStatement.setString(3, course.getDepartment());
            preparedStatement.setString(4, course.getPrerequisites());
            preparedStatement.setInt(5, course.getMaxEnrollment());
            preparedStatement.setInt(6, course.getCourseId()); // Now correctly using an integer
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(int courseId) {
        String query = "DELETE FROM courses WHERE course_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, courseId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
