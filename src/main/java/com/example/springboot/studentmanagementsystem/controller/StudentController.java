package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import com.example.springboot.studentmanagementsystem.service.StudentService;
import com.example.springboot.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> viewAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        student.setId(0);

        studentService.save(student);

        return student;
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable int studentId, @RequestBody Student student) {
        Student dbStudent = studentService.findById(studentId);

        if(dbStudent == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        student.setId(studentId);
        studentService.save(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String removeStudent(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);

        if(student == null) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        studentService.deleteById(studentId);

        return "Deleted Student id - " + studentId;
    }


    @GetMapping("/students/{studentId}/courses")
    public List<Course> viewStudentAssignedClasses(@PathVariable int studentId) {
        return studentService.viewStudentAssignedClasses(studentId);
    }

/*    @GetMapping("/students/classes")
    public List<List<Course>> viewStudentsAssignedClasses() {
        return studentService.viewStudentsAssignedClasses();
    }*/
}
