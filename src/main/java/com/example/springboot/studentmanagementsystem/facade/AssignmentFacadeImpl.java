package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dao.AdminRepository;
import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.service.AssignmentService;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentFacadeImpl implements AssignmentFacade {

    private AssignmentService assignmentService;
    private CourseService courseService;

    @Autowired
    public AssignmentFacadeImpl(AssignmentService assignmentService, CourseService courseService) {
        this.assignmentService = assignmentService;
        this.courseService = courseService;
    }


    @Override
    public void save(AssignmentDTO assignmentDTO) {
        Assignment assignment = convertToEntity(assignmentDTO);
        assignment.setId(0);
        assignmentService.save(assignment);
        assignmentDTO.setId(assignment.getId());
    }

    @Override
    public void update(AssignmentDTO assignmentDTO) {

        Assignment dbAssignment = assignmentService.findById(assignmentDTO.getId());

        if(dbAssignment == null) {
            throw new RuntimeException("Assignment id not found - " + assignmentDTO.getId());
        }

        Assignment assignment = convertToEntity(assignmentDTO);
        assignmentService.save(assignment);
    }

    @Override
    public void deleteById(int id) {
        Assignment assignment = assignmentService.findById(id);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + id);
        }

        assignmentService.deleteById(id);
    }

    @Override
    public List<AssignmentDTO> findAll() {
        return assignmentService.findAll().stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentDTO findById(int id) {
        Assignment assignment = assignmentService.findById(id);

        if(assignment == null) {
            throw new RuntimeException("Assignment id not found - " + id);
        }

        return convertToDto(assignment);
    }

    private AssignmentDTO convertToDto(Assignment assignment) {
        return new AssignmentDTO(assignment);
    }

    private Assignment convertToEntity(AssignmentDTO assignmentDTO) {

        Course course = courseService.findById(assignmentDTO.getCourseId());

        if(course == null) {
            throw new RuntimeException("Course id not found - " + assignmentDTO.getCourseId());
        }

        Assignment assignment = new Assignment(assignmentDTO);
        assignment.setCourse(course);

        return assignment;
    }
}
