package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.Course;

import java.util.List;

public interface CourseService {

    public void save(Course course);

    public void deleteById(int id);

    public List<Course> findAll();

    public Course findById(int id);

}
