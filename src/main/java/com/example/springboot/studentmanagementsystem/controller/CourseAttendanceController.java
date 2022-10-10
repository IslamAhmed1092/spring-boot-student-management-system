package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import com.example.springboot.studentmanagementsystem.service.AdminService;
import com.example.springboot.studentmanagementsystem.service.CourseAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseAttendanceController {
    private CourseAttendanceService courseAttendanceService;

    @Autowired
    public CourseAttendanceController(CourseAttendanceService courseAttendanceService) {
        this.courseAttendanceService = courseAttendanceService;
    }


    @GetMapping("/courseAttendances")
    public List<CourseAttendance> viewAllCourseAttendances() {
        return courseAttendanceService.findAll();
    }

    @GetMapping("/courseAttendances/{courseAttendanceId}")
    public CourseAttendance getCourseAttendance(@PathVariable int courseAttendanceId) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
        }

        return courseAttendance;
    }

    @PostMapping("/courseAttendances")
    public CourseAttendance addCourseAttendance(@RequestBody CourseAttendance courseAttendance) {

        courseAttendance.setId(0);

        courseAttendanceService.save(courseAttendance);

        return courseAttendance;
    }

    @PutMapping("/courseAttendances/{courseAttendanceId}")
    public CourseAttendance updateCourseAttendance(@PathVariable int courseAttendanceId, @RequestBody CourseAttendance courseAttendance) {
        CourseAttendance dbCourseAttendance = courseAttendanceService.findById(courseAttendanceId);

        if(dbCourseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
        }

        courseAttendance.setId(courseAttendanceId);
        courseAttendanceService.save(courseAttendance);
        return courseAttendance;
    }

    @DeleteMapping("/courseAttendances/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        CourseAttendance courseAttendance = courseAttendanceService.findById(courseAttendanceId);

        if(courseAttendance == null) {
            throw new RuntimeException("CourseAttendance id not found - " + courseAttendanceId);
        }

        courseAttendanceService.deleteById(courseAttendanceId);

        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


    @PostMapping("/courseAttendances/submitAll")
    public List<CourseAttendance> submitStudentsAttendance(@RequestBody List<CourseAttendance> courseAttendances) {

        courseAttendances = courseAttendances.stream().peek(courseAttendance -> courseAttendance.setId(0))
                .collect(Collectors.toList());

        courseAttendanceService.saveAll(
            courseAttendances
        );

        return courseAttendances;
    }
}
