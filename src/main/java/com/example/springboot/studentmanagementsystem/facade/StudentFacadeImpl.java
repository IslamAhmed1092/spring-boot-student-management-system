package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.CourseDTO;
import com.example.springboot.studentmanagementsystem.dto.StudentCoursesDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.service.AssignmentService;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import com.example.springboot.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private StudentService studentService;

    @Autowired
    public StudentFacadeImpl(StudentService studentService) {
        this.studentService = studentService;
    }


    @Override
    public void add(Student student) {
        student.setId(0);
        studentService.save(student);
    }

    @Override
    public void update(Student student) {
        Student dbStudent = studentService.findById(student.getId());

        if(dbStudent == null) {
            throw new RuntimeException("Student id not found - " + student.getId());
        }

        studentService.save(student);
    }

    @Override
    public void deleteById(int id) {
        Student student = studentService.findById(id);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + id);
        }

        studentService.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @Override
    public Student findById(int id) {
        Student student = studentService.findById(id);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + id);
        }

        return student;
    }

    @Override
    public List<CourseDTO> viewStudentAssignedClasses(int id) {
        return studentService.viewStudentAssignedClasses(id).stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<StudentCoursesDTO> viewStudentsAssignedClasses() {
        return studentService.findAll().stream().map(StudentCoursesDTO::new)
                .collect(Collectors.toList());
    }

}
