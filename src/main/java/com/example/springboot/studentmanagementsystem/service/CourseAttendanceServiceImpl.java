package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.CourseAttendanceRepository;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAttendanceServiceImpl implements CourseAttendanceService {

    private CourseAttendanceRepository courseAttendanceRepository;

    @Autowired
    public CourseAttendanceServiceImpl(CourseAttendanceRepository courseAttendanceRepository) {
        this.courseAttendanceRepository = courseAttendanceRepository;
    }

    @Override
    public void save(CourseAttendance courseAttendance) {
        courseAttendanceRepository.save(courseAttendance);
    }

    @Override
    public void saveAll(List<CourseAttendance> courseAttendances) {
        courseAttendanceRepository.saveAll(courseAttendances);
    }

    @Override
    public void deleteById(int id) {
        courseAttendanceRepository.deleteById(id);
    }

    @Override
    public List<CourseAttendance> findAll() {
        return courseAttendanceRepository.findAll();
    }

    @Override
    public CourseAttendance findById(int id) {
        Optional<CourseAttendance> result = courseAttendanceRepository.findById(id);
        return result.orElse(null);
    }
}
