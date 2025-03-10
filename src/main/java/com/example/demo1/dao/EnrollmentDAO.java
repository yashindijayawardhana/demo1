package com.example.demo1.dao;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Enrollment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {
    // Method to add a new enrollment
    public boolean enrollStudent(String studentId, String courseId, Date enrollmentDate) {
        String query = "INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, studentId);
            pstmt.setString(2, courseId);
            pstmt.setDate(3, enrollmentDate);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // Returns true if the insertion was successful

        } catch (SQLException e) {
            System.out.println("Error enrolling student: " + e.getMessage());
            return false;
        }
    }

    // Method to retrieve all enrollments
    public List<Enrollment> getAllEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();
        String query = "SELECT * FROM enrollment";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                        rs.getInt("id"),
                        rs.getString("student_id"),
                        rs.getString("course_id"),
                        rs.getDate("enrollment_date")
                );
                enrollments.add(enrollment);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving enrollments: " + e.getMessage());
        }
        return enrollments;
    }

    // Method to drop a student from a course
    public boolean dropEnrollment(String studentId, String courseId) {
        String query = "DELETE FROM enrollment WHERE student_id = ? AND course_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, studentId);
            pstmt.setString(2, courseId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;  // Returns true if deletion was successful

        } catch (SQLException e) {
            System.out.println("Error dropping enrollment: " + e.getMessage());
            return false;
        }
    }
}
