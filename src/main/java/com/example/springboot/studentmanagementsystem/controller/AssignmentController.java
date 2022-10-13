package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.facade.AssignmentFacade;
import com.example.springboot.studentmanagementsystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssignmentController {
    private AssignmentFacade assignmentFacade;

    @Autowired
    public AssignmentController(AssignmentFacade assignmentFacade) {
        this.assignmentFacade = assignmentFacade;
    }


    @GetMapping("/assignments")
    public List<AssignmentDTO> viewAllAssignments() {
        return assignmentFacade.findAll();
    }

    @GetMapping("/assignments/{assignmentId}")
    public AssignmentDTO getAssignment(@PathVariable int assignmentId) {
        return assignmentFacade.findById(assignmentId);
    }

    @PostMapping("/assignments")
    public AssignmentDTO addAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        assignmentFacade.add(assignmentDTO);
        return assignmentDTO;
    }

    @PutMapping("/assignments")
    public AssignmentDTO updateAssignment(@RequestBody AssignmentDTO assignmentDTO) {
        assignmentFacade.update(assignmentDTO);
        return assignmentDTO;
    }

    @DeleteMapping("/assignments/{assignmentId}")
    public String removeAssignment(@PathVariable int assignmentId) {
        assignmentFacade.deleteById(assignmentId);
        return "Deleted Assignment id - " + assignmentId;
    }
}
