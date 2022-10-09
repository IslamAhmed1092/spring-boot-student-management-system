package com.example.springboot.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.List;


@Table
@Entity(name = "teacher")
public class Teacher {

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

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
}
