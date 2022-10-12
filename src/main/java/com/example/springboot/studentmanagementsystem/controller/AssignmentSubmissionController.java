package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.AssignmentSubmissionDTO;
import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;
import com.example.springboot.studentmanagementsystem.facade.AssignmentSubmissionFacade;
import com.example.springboot.studentmanagementsystem.service.AssignmentSubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentSubmissionController {
    private AssignmentSubmissionFacade assignmentSubmissionFacade;

    @Autowired
    public AssignmentSubmissionController(AssignmentSubmissionFacade assignmentSubmissionFacade) {
        this.assignmentSubmissionFacade = assignmentSubmissionFacade;
    }


    @GetMapping("/assignmentSubmissions")
    public List<AssignmentSubmissionDTO> viewAllAssignmentSubmissions() {
        return assignmentSubmissionFacade.findAll();
    }

    @GetMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public AssignmentSubmissionDTO getAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        return assignmentSubmissionFacade.findById(assignmentSubmissionId);
    }

    @PostMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO addAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        assignmentSubmissionFacade.add(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @PutMapping("/assignmentSubmissions")
    public AssignmentSubmissionDTO updateAssignmentSubmission(@RequestBody AssignmentSubmissionDTO assignmentSubmissionDTO) {
        assignmentSubmissionFacade.update(assignmentSubmissionDTO);
        return assignmentSubmissionDTO;
    }

    @DeleteMapping("/assignmentSubmissions/{assignmentSubmissionId}")
    public String removeAssignmentSubmission(@PathVariable int assignmentSubmissionId) {
        assignmentSubmissionFacade.deleteById(assignmentSubmissionId);
        return "Deleted AssignmentSubmission id - " + assignmentSubmissionId;
    }
}
