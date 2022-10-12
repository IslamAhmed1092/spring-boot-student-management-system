package com.example.springboot.studentmanagementsystem.facade;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.AssignmentSubmissionDTO;

import java.util.List;

public interface AssignmentSubmissionFacade {
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO);

    public void update(AssignmentSubmissionDTO assignmentSubmissionDTO);

    public void deleteById(int id);

    public List<AssignmentSubmissionDTO> findAll();

    public AssignmentSubmissionDTO findById(int id);
}
