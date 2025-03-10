package com.example.demo1.dao;

import com.example.demo1.db.DBConnection;
import com.example.demo1.models.Course;
import com.example.demo1.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static boolean addStudent(Student student) {
        String query = "INSERT INTO students (full_name, date_of_birth, program, year, contact_info) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, student.getFullName());
            stmt.setDate(2, Date.valueOf(student.getDateOfBirth()));
            stmt.setString(3, student.getProgram());
            stmt.setInt(4, student.getYear());
            stmt.setString(5, student.getContactInfo());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        DatabaseMetaData DBConnection = null;
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("program"),
                        rs.getInt("year"),
                        rs.getString("contact_info")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static boolean registerStudent(Student newStudent) {
        return false;
    }

    public static Student getStudentById(String studentId) {
        return null;
    }

    public static Course getRegisteredCourses(String studentId) {
        return null;
    }

    public static List<Student> searchStudents(String keyword) {
        return new ArrayList<Student>();
    }

    public static boolean deleteStudent(Object studentID) {
        return false;
    }
}