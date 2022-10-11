package com.example.springboot.studentmanagementsystem.facade;


import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AssignmentFacade {
    public void save(AssignmentDTO assignmentDTO);

    public void update(AssignmentDTO assignmentDTO);

    public void deleteById(int id);

    public List<AssignmentDTO> findAll();

    public AssignmentDTO findById(int id);
}
