package com.example.demo1.models;

import java.time.LocalDate;

public class Student {
    private int studentId;
    private String fullName;
    private String dateOfBirth;
    private String program;
    private int year;
    private String contactInfo;
    private char[] completedCredits;

    public Student(int studentId, String fullName, String dateOfBirth, String program, int year, String contactInfo) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.program = program;
        this.year = year;
        this.contactInfo = contactInfo;
    }

    public Student(String studentId, String fullName, String dateOfBirth, String program, String year, String contactInfo) {
    }

    public Student(int studentId, String fullName, LocalDate dateOfBirth, String program, int year, String contactInfo) {
    }

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getName() {
        return "";
    }

    public String getId() {
        return "";
    }

    public char[] getGpa() {
        return new char[0];
    }

    public char[] getCompletedCredits() {
        return completedCredits;
    }

    public void setCompletedCredits(char[] completedCredits) {
        this.completedCredits = completedCredits;
    }

    public Object getStudentID() {
        return null;
    }
}
