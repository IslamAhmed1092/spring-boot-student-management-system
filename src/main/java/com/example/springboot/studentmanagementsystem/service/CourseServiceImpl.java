package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.CourseRepository;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<Student> getStudentsInCourse(int courseId) {
        return courseRepository.getStudentsInCourse(courseId);
    }

    @Override
    public List<Assignment> getAssignmentsInCourse(int courseId) {
        return courseRepository.getAssignmentsInCourse(courseId);
    }
}
