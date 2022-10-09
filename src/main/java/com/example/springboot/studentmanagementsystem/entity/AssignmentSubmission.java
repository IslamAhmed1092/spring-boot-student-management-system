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

}
