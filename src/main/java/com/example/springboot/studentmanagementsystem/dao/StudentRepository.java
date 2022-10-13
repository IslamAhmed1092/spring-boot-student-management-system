package com.example.springboot.studentmanagementsystem.dao;

import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select s.enrolledCourses from student s where s.id =:studentId")
    public List<Course> viewStudentAssignedClasses(int studentId);

    @Query("select s.enrolledCourses from student s")
    public List<List<Course>> viewStudentsAssignedClasses();
}
