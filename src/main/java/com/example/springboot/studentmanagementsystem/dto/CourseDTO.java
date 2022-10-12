package com.example.springboot.studentmanagementsystem.dto;

import com.example.springboot.studentmanagementsystem.entity.Course;

public class CourseDTO {

    private int id;

    private String name;

    private int teacherId;

    public CourseDTO() {
    }

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.teacherId = course.getTeacher().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

}
