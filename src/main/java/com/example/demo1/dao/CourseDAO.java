package com.example.demo1.dao;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    // Insert a new course
    public boolean addCourse(Course course) {
        String query = "INSERT INTO courses (course_name, duration) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, course.getCourseName());
            pstmt.setString(2, course.getDuration());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error inserting course: " + e.getMessage());
            return false;
        }
    }

    // Retrieve all courses
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Course course = new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getString("duration")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving courses: " + e.getMessage());
        }
        return courses;
    }

    // Update a course
    public boolean updateCourse(int courseId, String newName, String newDuration) {
        String query = "UPDATE courses SET course_name = ?, duration = ? WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newName);
            pstmt.setString(2, newDuration);
            pstmt.setInt(3, courseId);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating course: " + e.getMessage());
            return false;
        }
    }

    // Delete a course
    public boolean deleteCourse(int courseId) {
        String query = "DELETE FROM courses WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, courseId);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting course: " + e.getMessage());
            return false;
        }
    }
}
