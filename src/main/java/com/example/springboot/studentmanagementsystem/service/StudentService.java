package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    public void save(Student student);

    public void deleteById(int id);

    public List<Student> findAll();

    public Student findById(int id);

}
