package com.example.demo1.models;

public class Course {
    private int courseId;
    private String courseName;
    private int creditHours;
    private String department;
    private String prerequisites;
    private int maxEnrollment;

    public Course(int courseId, String courseName, int creditHours, String department, String prerequisites, int maxEnrollment) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.department = department;
        this.prerequisites = prerequisites;
        this.maxEnrollment = maxEnrollment;
    }

    public int getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public int getCreditHours() { return creditHours; }
    public String getDepartment() { return department; }
    public String getPrerequisites() { return prerequisites; }
    public int getMaxEnrollment() { return maxEnrollment; }
}
