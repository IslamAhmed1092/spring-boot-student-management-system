package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.CourseDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;

import java.util.List;

public interface CourseFacade {

    public void add(CourseDTO courseDTO);

    public void update(CourseDTO courseDTO);

    public void deleteById(int id);

    public List<CourseDTO> findAll();

    public CourseDTO findById(int id);

    public List<Student> getStudentsInCourse(int courseId);

    public List<AssignmentDTO> getAssignmentsInCourse(int courseId);
}
