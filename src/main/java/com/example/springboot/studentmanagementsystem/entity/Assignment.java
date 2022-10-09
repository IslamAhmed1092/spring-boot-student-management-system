package com.example.springboot.studentmanagementsystem.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "due_date")
    private Date dueDate;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSubmission> assignmentSubmissions;

    public Assignment() {
    }

    public Assignment(String description, Course course, Date dueDate) {
        this.description = description;
        this.course = course;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<AssignmentSubmission> getAssignmentSubmissions() {
        return assignmentSubmissions;
    }

    public void setAssignmentSubmissions(List<AssignmentSubmission> assignmentSubmissions) {
        this.assignmentSubmissions = assignmentSubmissions;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
