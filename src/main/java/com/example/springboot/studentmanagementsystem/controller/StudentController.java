package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.CourseDTO;
import com.example.springboot.studentmanagementsystem.dto.StudentCoursesDTO;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import com.example.springboot.studentmanagementsystem.facade.StudentFacade;
import com.example.springboot.studentmanagementsystem.service.StudentService;
import com.example.springboot.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentFacade studentFacade;

    @Autowired
    public StudentController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }


    @GetMapping("/students")
    public List<Student> viewAllStudents() {
        return studentFacade.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return studentFacade.findById(studentId);
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        studentFacade.add(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentFacade.update(student);
        return student;
    }

    @DeleteMapping("/students/{studentId}")
    public String removeStudent(@PathVariable int studentId) {
        studentFacade.deleteById(studentId);
        return "Deleted Student id - " + studentId;
    }


    @GetMapping("/students/{studentId}/courses")
    public List<CourseDTO> viewStudentAssignedClasses(@PathVariable int studentId) {
        return studentFacade.viewStudentAssignedClasses(studentId);
    }

    @GetMapping("/students/courses")
    public List<StudentCoursesDTO> viewStudentsAssignedClasses() {
        return studentFacade.viewStudentsAssignedClasses();
    }
}
