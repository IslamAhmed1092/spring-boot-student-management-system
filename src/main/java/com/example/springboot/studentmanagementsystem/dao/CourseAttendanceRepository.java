package com.example.springboot.studentmanagementsystem.dao;

import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseAttendanceRepository extends JpaRepository<CourseAttendance, Integer> {

}
