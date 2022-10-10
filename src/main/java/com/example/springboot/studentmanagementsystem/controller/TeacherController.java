package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import com.example.springboot.studentmanagementsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping("/teachers")
    public List<Teacher> viewAllTeachers() {
        return teacherService.findAll();
    }

    @GetMapping("/teachers/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        return teacher;
    }

    @PostMapping("/teachers")
    public Teacher addTeacher(@RequestBody Teacher teacher) {

        teacher.setId(0);

        teacherService.save(teacher);

        return teacher;
    }

    @PutMapping("/teachers/{teacherId}")
    public Teacher updateTeacher(@PathVariable int teacherId, @RequestBody Teacher teacher) {
        Teacher dbTeacher = teacherService.findById(teacherId);

        if(dbTeacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        teacher.setId(teacherId);
        teacherService.save(teacher);
        return teacher;
    }

    @DeleteMapping("/teachers/{teacherId}")
    public String removeTeacher(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);

        if(teacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);
        }

        teacherService.deleteById(teacherId);

        return "Deleted Teacher id - " + teacherId;
    }

    @GetMapping("/teachers/{teacherId}/courses")
    public List<Course> getAllClasses(@PathVariable int teacherId) {
        return teacherService.getAllClasses(teacherId);
    }

}
