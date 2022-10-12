package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.CourseAttendanceDTO;
import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import com.example.springboot.studentmanagementsystem.facade.CourseAttendanceFacade;
import com.example.springboot.studentmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseAttendanceController {
    private CourseAttendanceFacade courseAttendanceFacade;

    @Autowired
    public CourseAttendanceController(CourseAttendanceFacade courseAttendanceFacade) {
        this.courseAttendanceFacade = courseAttendanceFacade;
    }


    @GetMapping("/courseAttendances")
    public List<CourseAttendanceDTO> viewAllCourseAttendances() {
        return courseAttendanceFacade.findAll();
    }

    @GetMapping("/courseAttendances/{courseAttendanceId}")
    public CourseAttendanceDTO getCourseAttendance(@PathVariable int courseAttendanceId) {
        return courseAttendanceFacade.findById(courseAttendanceId);
    }

    @PostMapping("/courseAttendances")
    public CourseAttendanceDTO addCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceFacade.add(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @PutMapping("/courseAttendances")
    public CourseAttendanceDTO updateCourseAttendance(@RequestBody CourseAttendanceDTO courseAttendanceDTO) {
        courseAttendanceFacade.update(courseAttendanceDTO);
        return courseAttendanceDTO;
    }

    @DeleteMapping("/courseAttendances/{courseAttendanceId}")
    public String removeCourseAttendance(@PathVariable int courseAttendanceId) {
        courseAttendanceFacade.deleteById(courseAttendanceId);
        return "Deleted CourseAttendance id - " + courseAttendanceId;
    }


    @PostMapping("/courseAttendances/submitAll")
    public List<CourseAttendanceDTO> submitStudentsAttendance(@RequestBody List<CourseAttendanceDTO> courseAttendanceDTOs) {

        courseAttendanceFacade.addAll(
                courseAttendanceDTOs
        );

        return courseAttendanceDTOs;
    }
}
