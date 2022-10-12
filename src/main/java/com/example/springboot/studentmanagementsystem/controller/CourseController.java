package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.CourseDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.facade.CourseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseFacade courseFacade;

    @Autowired
    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }


    @GetMapping("/courses")
    public List<CourseDTO> viewAllCourses() {
        return courseFacade.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public CourseDTO getCourse(@PathVariable int courseId) {
        return courseFacade.findById(courseId);
    }

    @PostMapping("/courses")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        courseFacade.add(courseDTO);
        return courseDTO;
    }

    @PutMapping("/courses")
    public CourseDTO updateCourse(@RequestBody CourseDTO courseDTO) {
        courseFacade.update(courseDTO);
        return courseDTO;
    }

    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        courseFacade.deleteById(courseId);
        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseFacade.getStudentsInCourse(courseId);
    }

    @GetMapping("/courses/{courseId}/assignments")
    public List<AssignmentDTO> getAssignmentsInCourse(@PathVariable int courseId) {
        return courseFacade.getAssignmentsInCourse(courseId);
    }
}
