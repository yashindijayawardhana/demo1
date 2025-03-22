package com.example.demo1.models;

public class Faculty {
    private int facultyId;
    private String name;
    private String department;
    private String email;

    public Faculty(int facultyId, String name, String department, String email) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // Getters and Setters
    public int getFacultyId() { return facultyId; }
    public void setFacultyId(int facultyId) { this.facultyId = facultyId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}