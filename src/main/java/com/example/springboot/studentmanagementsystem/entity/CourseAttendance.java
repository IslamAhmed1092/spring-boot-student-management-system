package com.example.springboot.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "course_attendance")
public class CourseAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "attendance_date")
    private Date attendanceDate;

    @Column(name = "status")
    private String status;

}
