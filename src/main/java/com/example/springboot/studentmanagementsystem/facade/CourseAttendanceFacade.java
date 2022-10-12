package com.example.springboot.studentmanagementsystem.facade;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.CourseAttendanceDTO;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;

import java.util.List;

public interface CourseAttendanceFacade {
    public void add(CourseAttendanceDTO courseAttendanceDTO);

    public void update(CourseAttendanceDTO courseAttendanceDTO);

    public void addAll(List<CourseAttendanceDTO> courseAttendanceDTOs);

    public void deleteById(int id);

    public List<CourseAttendanceDTO> findAll();

    public CourseAttendanceDTO findById(int id);
}
