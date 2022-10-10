package com.example.springboot.studentmanagementsystem.dao;

import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("select c.enrolledStudents from course c where c.id =:courseId")
    List<Student> getStudentsInCourse(int courseId);

    @Query("select c.assignments from course c where c.id =:courseId")
    List<Assignment> getAssignmentsInCourse(int courseId);

}
