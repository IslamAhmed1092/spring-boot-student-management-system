package com.example.springboot.studentmanagementsystem.dto;

import com.example.springboot.studentmanagementsystem.entity.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentCoursesDTO {

    private int studentId;

    private String email;

    private List<CourseDTO> assignedCourses;

    public StudentCoursesDTO() {
    }

    public StudentCoursesDTO(Student student) {
        this.studentId = student.getId();
        this.email = student.getEmail();
        this.assignedCourses = student.getEnrolledCourses().stream().map(CourseDTO::convertToDTO).collect(Collectors.toList());
    }

    public static StudentCoursesDTO convertToDTO(Student student) {
        return new StudentCoursesDTO(student);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CourseDTO> getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(List<CourseDTO> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }
}
