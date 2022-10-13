package com.example.springboot.studentmanagementsystem.dto;

import com.example.springboot.studentmanagementsystem.entity.Assignment;
import com.example.springboot.studentmanagementsystem.entity.AssignmentSubmission;
import com.example.springboot.studentmanagementsystem.entity.CourseAttendance;
import com.example.springboot.studentmanagementsystem.entity.Student;

import javax.persistence.*;
import java.util.Date;

public class AssignmentSubmissionDTO {

    private int id;

    private int studentId;

    private int assignmentId;

    private Date submissionDate;

    private String contentSubmitted;

    private float mark;

    public AssignmentSubmissionDTO() {
    }

    public AssignmentSubmissionDTO(AssignmentSubmission assignmentSubmission) {
        this.id = assignmentSubmission.getId();
        this.studentId = assignmentSubmission.getStudent().getId();
        this.assignmentId = assignmentSubmission.getAssignment().getId();
        this.submissionDate = assignmentSubmission.getSubmissionDate();
        this.contentSubmitted = assignmentSubmission.getContentSubmitted();
        this.mark = assignmentSubmission.getMark();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getContentSubmitted() {
        return contentSubmitted;
    }

    public void setContentSubmitted(String contentSubmitted) {
        this.contentSubmitted = contentSubmitted;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

}
