package com.example.springboot.studentmanagementsystem.entity;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity(name = "assignment_submission")
public class AssignmentSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Column(name = "submission_date")
    private Date submissionDate;

    @Column(name = "content_submitted")
    private String contentSubmitted;

    @Column(name = "mark")
    private float mark;

    public AssignmentSubmission() {
    }

    public AssignmentSubmission(Student student, Assignment assignment, Date submissionDate, String contentSubmitted, float mark) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.contentSubmitted = contentSubmitted;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
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
