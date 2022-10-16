package com.example.springboot.studentmanagementsystem.facade;

import com.example.springboot.studentmanagementsystem.dto.AssignmentDTO;
import com.example.springboot.studentmanagementsystem.dto.AssignmentSubmissionDTO;
import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;
import com.example.springboot.studentmanagementsystem.entity.Course;
import com.example.springboot.studentmanagementsystem.entity.Student;
import com.example.springboot.studentmanagementsystem.exception.NotFoundException;
import com.example.springboot.studentmanagementsystem.exception.StudentNotEnrolledException;
import com.example.springboot.studentmanagementsystem.service.AssignmentService;
import com.example.springboot.studentmanagementsystem.service.AssignmentSubmissionService;
import com.example.springboot.studentmanagementsystem.service.CourseService;
import com.example.springboot.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentSubmissionFacadeImpl implements AssignmentSubmissionFacade {

    private AssignmentSubmissionService assignmentSubmissionService;
    private StudentService studentService;
    private AssignmentService assignmentService;

    @Autowired
    public AssignmentSubmissionFacadeImpl(AssignmentSubmissionService assignmentSubmissionService,  StudentService studentService, AssignmentService assignmentService) {
        this.assignmentSubmissionService = assignmentSubmissionService;
        this.studentService = studentService;
        this.assignmentService = assignmentService;
    }


    @Override
    public void add(AssignmentSubmissionDTO assignmentSubmissionDTO) {
        AssignmentSubmission assignmentSubmission = convertToEntity(assignmentSubmissionDTO);
        assignmentSubmission.setId(0);
        assignmentSubmissionService.save(assignmentSubmission);
        assignmentSubmissionDTO.setId(assignmentSubmission.getId());
    }

    @Override
    public void update(AssignmentSubmissionDTO assignmentSubmissionDTO) {

        AssignmentSubmission dbAssignmentSubmission = assignmentSubmissionService.findById(assignmentSubmissionDTO.getId());

        if(dbAssignmentSubmission == null) {
            throw new NotFoundException("AssignmentSubmission id not found - " + assignmentSubmissionDTO.getId());
        }

        AssignmentSubmission assignmentSubmission = convertToEntity(assignmentSubmissionDTO);
        assignmentSubmissionService.save(assignmentSubmission);
    }

    @Override
    public void deleteById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new NotFoundException("AssignmentSubmission id not found - " + id);
        }

        assignmentSubmissionService.deleteById(id);
    }

    @Override
    public List<AssignmentSubmissionDTO> findAll() {
        return assignmentSubmissionService.findAll().stream().map(AssignmentSubmissionDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public AssignmentSubmissionDTO findById(int id) {
        AssignmentSubmission assignmentSubmission = assignmentSubmissionService.findById(id);

        if(assignmentSubmission == null) {
            throw new NotFoundException("AssignmentSubmission id not found - " + id);
        }

        return new AssignmentSubmissionDTO(assignmentSubmission);
    }

    private AssignmentSubmission convertToEntity(AssignmentSubmissionDTO assignmentSubmissionDTO) {

        Student student = studentService.findById(assignmentSubmissionDTO.getStudentId());

        if(student == null) {
            throw new NotFoundException("Student id not found - " + assignmentSubmissionDTO.getStudentId());
        }

        Assignment assignment = assignmentService.findById(assignmentSubmissionDTO.getAssignmentId());

        if(assignment == null) {
            throw new NotFoundException("Assignment id not found - " + assignmentSubmissionDTO.getAssignmentId());
        }

        if(!studentService.viewStudentAssignedClasses(student.getId()).contains(assignment.getCourse())) {
            throw new StudentNotEnrolledException("Student with id " + assignmentSubmissionDTO.getStudentId() + " isn't enrolled to the course with id " + assignment.getCourse().getId() + " which contains the assignment with id " + assignment.getId());
        }

        AssignmentSubmission assignmentSubmission = new AssignmentSubmission(assignmentSubmissionDTO);
        assignmentSubmission.setStudent(student);
        assignmentSubmission.setAssignment(assignment);

        return assignmentSubmission;
    }
}
