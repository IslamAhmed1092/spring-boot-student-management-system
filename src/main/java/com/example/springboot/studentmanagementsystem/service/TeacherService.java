package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherService {

    public void save(Teacher teacher);

    public void deleteById(int id);

    public List<Teacher> findAll();

    public Teacher findById(int id);

    public List<Course> getAllClasses(int teacherId);

}
