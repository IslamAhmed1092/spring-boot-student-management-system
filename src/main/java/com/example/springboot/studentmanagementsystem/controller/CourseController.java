package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/courses")
    public List<Course> viewAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        return course;
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {

        course.setId(0);

        courseService.save(course);

        return course;
    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        Course dbCourse = courseService.findById(courseId);

        if(dbCourse == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        course.setId(courseId);
        courseService.save(course);
        return course;
    }

    @DeleteMapping("/courses/{courseId}")
    public String removeCourse(@PathVariable int courseId) {
        Course course = courseService.findById(courseId);

        if(course == null) {
            throw new RuntimeException("Course id not found - " + courseId);
        }

        courseService.deleteById(courseId);

        return "Deleted Course id - " + courseId;
    }

    @GetMapping("/courses/{courseId}/students")
    public List<Student> getStudentsInCourse(@PathVariable int courseId) {
        return courseService.getStudentsInCourse(courseId);
    }
}
