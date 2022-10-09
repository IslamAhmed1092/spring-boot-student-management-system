package com.example.springboot.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;

@Table
@Entity(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> enrolledStudents;

    @OneToMany(mappedBy = "course")
    private List<CourseAttendance> courseAttendances;

    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments;
}
