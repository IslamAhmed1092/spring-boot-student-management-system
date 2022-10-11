package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }


    @GetMapping("/assignments")
    public List<Assignment> viewAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/assignments/{assignmentId}")
    public Assignment getAssignment(@PathVariable int assignmentId) {
        Assignment assignment = assignmentService.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        return assignment;
    }

    @PostMapping("/assignments")
    public AssignmentDTO addAssignment(@RequestBody AssignmentDTO assignmentDTO) {

        assignmentDTO.setId(0);

        assignmentService.save(assignmentDTO);

        return assignmentDTO;
    }

    @PutMapping("/assignments/{assignmentId}")
    public AssignmentDTO updateAssignment(@PathVariable int assignmentId, @RequestBody AssignmentDTO assignmentDTO) {
        Assignment dbAssignment = assignmentService.findById(assignmentId);

        if(dbAssignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        assignmentDTO.setId(assignmentId);
        assignmentService.save(assignmentDTO);
        return assignmentDTO;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        Assignment assignment = assignmentService.findById(assignmentId);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentId);
        }

        assignmentService.deleteById(assignmentId);

        return "Deleted Assignment id - " + assignmentId;
    }
}
