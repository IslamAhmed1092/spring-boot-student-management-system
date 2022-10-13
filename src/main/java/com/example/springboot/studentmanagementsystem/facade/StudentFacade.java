package com.example.springboot.studentmanagementsystem.facade;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.StudentCoursesDTO;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;

import java.util.List;

public interface StudentFacade {
    public void add(Student student);

    public void update(Student student);

    public void deleteById(int id);

    public List<Student> findAll();

    public Student findById(int id);

    public List<Course> viewStudentAssignedClasses(int id);

    public List<StudentCoursesDTO> viewStudentsAssignedClasses();
}
