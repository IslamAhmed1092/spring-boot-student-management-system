package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Teacher;

import java.util.List;

public interface TeacherService {

    public void addTeacher(Teacher teacher);

    public void removeTeacher(int id);

    public List<Teacher> viewAllTeachers();

    public Teacher viewTeacherDetails(int id);

}
