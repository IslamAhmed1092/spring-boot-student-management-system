package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.AssignmentRepository;
import com.example.springboot.studentmanagementsystem.dao.CourseRepository;
import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;
    private CourseRepository courseRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository, CourseRepository courseRepository) {
        this.assignmentRepository = assignmentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(AssignmentDTO assignmentDTO) {
        Optional<Course> result = courseRepository.findById(assignmentDTO.getCourseId());
        if(result.isPresent()) {
            Assignment assignment = new Assignment(assignmentDTO);
            assignment.setCourse(result.get());
            assignmentRepository.save(assignment);
            assignmentDTO.setId(assignment.getId());
        } else {
            throw new RuntimeException("Course id not found - " + assignmentDTO.getCourseId());
        }
    }

    @Override
    public void deleteById(int id) {
        assignmentRepository.deleteById(id);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    @Override
    public Assignment findById(int id) {
        Optional<Assignment> result = assignmentRepository.findById(id);
        return result.orElse(null);
    }
}
