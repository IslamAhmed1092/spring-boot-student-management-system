package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.dao.AssignmentSubmissionRepository;
import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService {

    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    public AssignmentSubmissionServiceImpl(AssignmentSubmissionRepository assignmentSubmissionRepository) {
        this.assignmentSubmissionRepository = assignmentSubmissionRepository;
    }

    @Override
    public void save(AssignmentSubmission assignmentSubmission) {
        assignmentSubmissionRepository.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        assignmentSubmissionRepository.deleteById(id);
    }

    @Override
    public List<AssignmentSubmission> findAll() {
        return assignmentSubmissionRepository.findAll();
    }

    @Override
    public AssignmentSubmission findById(int id) {
        Optional<AssignmentSubmission> result = assignmentSubmissionRepository.findById(id);
        return result.orElse(null);
    }
}
