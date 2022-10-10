package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.AssignmentRepository;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public void save(Assignment assignment) {
        assignmentRepository.save(assignment);
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
