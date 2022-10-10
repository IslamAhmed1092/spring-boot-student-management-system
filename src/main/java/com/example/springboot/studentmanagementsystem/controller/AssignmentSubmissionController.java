package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;
import com.example.springboot.studentmanagementsystem.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionService assignmentSubmissionService;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
    }


    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmission> viewAllAssignmentSubmissions() {
        return assignmentSubmissionService.findAll();
    }

    @GetMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmission getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
        }

        return assignmentSubmission;
    }

    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmission addAssignmentSubmission(@RequestBody AssignmentSubmission assignmentSubmission) {

        assignmentSubmission.setId(0);

        assignmentSubmissionService.save(assignmentSubmission);

        return assignmentSubmission;
    }

    @PutMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmission updateAssignmentSubmission(@PathVariable int assignmentSubmissionId, @RequestBody AssignmentSubmission assignmentSubmission) {
        AssignmentSubmission dbAssignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);

        if(dbAssignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
        }

        assignmentSubmission.setId(assignmentSubmissionId);
        assignmentSubmissionService.save(assignmentSubmission);
        return assignmentSubmission;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionId);

        if(assignmentSubmission == null) {
            throw new RuntimeException("AssignmentSubmission id not found - " + assignmentSubmissionId);
        }

        assignmentSubmissionService.deleteById(assignmentSubmissionId);

        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
