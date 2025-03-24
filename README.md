# Course Registration System (CRS)

## Overview
The **Course Registration System (CRS)** is a JavaFX-based application designed to automate the course registration process at educational institutions. It provides an intuitive interface for students to manage their academic schedules and enables faculty and administrative staff to maintain and track course and student data efficiently.

## Features
- **Course Management**: Maintain comprehensive details of all courses, including course ID, title, credit hours, department, prerequisites, and maximum enrollment capacity.
- **Student Management**: Manage student profiles, including student ID, name, date of birth, program of study, year, and contact information.
- **Enrollment Management**: Enable students to register for courses based on eligibility and course capacity. Allow students to add or drop courses during a designated period.
- **Academic Records**: Keep a record of all courses a student has enrolled in, including grades received.
- **Reporting Tools**: Generate reports on course enrollments, vacancies, and student schedules.
- **User Authentication**: Implement role-based access control (RBAC) for students, faculty, and administrative staff.

## System Requirements
- **Java**: JDK 17 or later
- **MySQL**: Version 8.0 or later
- **JavaFX**: Included in the project dependencies
- **IDE**: IntelliJ IDEA, Eclipse, or any Java IDE
- **MySQL Connector/J**: Version 8.0 or later (for database connectivity)



## User Guide
### For Students
#### Log In:
- Open the application and log in using your student email and password.

#### View Enrolled Courses:
- Navigate to the "View Courses" section to see the list of courses you are currently enrolled in.

#### Register for Courses:
- Go to the "Register Courses" section.
- Search for available courses and register for them based on eligibility and availability.

#### View Academic Records:
- Check your academic records, including grades for completed courses, in the "Academic Records" section.

### For Administrators
#### Log In:
- Open the application and log in using your admin credentials.

#### Manage Courses:
- Add, update, or delete courses in the "Manage Courses" section.

#### Manage Students:
- Add, update, or delete student profiles in the "Manage Students" section.

#### Manage Enrollments:
- Approve or reject course registrations in the "Enrollment Management" section.

#### Generate Reports:
- Generate reports on course enrollments, vacancies, and student schedules in the "Reports" section.

## Project Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-controls</artifactId>
        <version>17.0.12</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-fxml</artifactId>
        <version>17.0.12</version>
    </dependency>
    <dependency>
        <groupId>org.openjfx</groupId>
        <artifactId>javafx-graphics</artifactId>
        <version>17.0.12</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.30</version>
    </dependency>
</dependencies>
```

## Author
**Janage Dona Yashindi Iduwarana Jayawardhana**
- **Institution**: IJSE - Institute of Software Engineering
- **Course**: Diploma in Software Engineering - Comprehensive Master of Java Developer (CMJD)
- **GitHub**: [GitHub Profile](https://github.com/yashindijayawardhana?tab=repositories)



