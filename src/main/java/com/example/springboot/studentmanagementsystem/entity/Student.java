package com.example.springboot.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "age")
    private String age;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> enrolledCourses;

    @OneToMany(mappedBy = "student")
    private List<CourseAttendance> courseAttendances;

    @OneToMany(mappedBy = "student")
    private List<AssignmentSubmission> assignmentSubmissions;


}
