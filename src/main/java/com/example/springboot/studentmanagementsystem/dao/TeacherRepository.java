package com.example.springboot.studentmanagementsystem.dao;

import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query("select t.courses from teacher t where t.id =:teacherId")
    public List<Course> getAllClasses(int teacherId);

}
