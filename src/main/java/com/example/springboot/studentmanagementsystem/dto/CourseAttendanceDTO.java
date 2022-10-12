package com.example.springboot.studentmanagementsystem.dto;

import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import com.example.springboot.studentmanagementsystem.entity.Student;

import javax.persistence.*;
import java.util.Date;

public class CourseAttendanceDTO {

    private int id;

    private int courseId;

    private int studentId;
    private Date attendanceDate;

    private String status;

    public CourseAttendanceDTO() {
    }

    public CourseAttendanceDTO(CourseAttendance courseAttendance) {
        this.id = courseAttendance.getId();
        this.courseId = courseAttendance.getCourse().getId();
        this.studentId = courseAttendance.getStudent().getId();
        this.attendanceDate = courseAttendance.getAttendanceDate();
        this.status = courseAttendance.getStatus();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static CourseAttendanceDTO convertToDTO(CourseAttendance courseAttendance) {
        return new CourseAttendanceDTO(courseAttendance);
    }

}
