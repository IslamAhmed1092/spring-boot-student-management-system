package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.TeacherRepository;
import com.example.springboot.studentmanagementsystem.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void removeTeacher(int id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> viewAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher viewTeacherDetails(int id) {
        Optional<Teacher> result = teacherRepository.findById(id);
        return result.orElse(null);
    }
}
