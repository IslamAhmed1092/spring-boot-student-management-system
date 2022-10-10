package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;

import java.util.List;

public interface AssignmentSubmissionService {

    public void save(AssignmentSubmission assignmentSubmission);

    public void deleteById(int id);

    public List<AssignmentSubmission> findAll();

    public AssignmentSubmission findById(int id);

}
