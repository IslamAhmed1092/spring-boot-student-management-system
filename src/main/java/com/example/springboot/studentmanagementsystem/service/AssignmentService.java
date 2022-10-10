package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.Assignment;

import java.util.List;

public interface AssignmentService {

    public void save(Assignment assignment);

    public void deleteById(int id);

    public List<Assignment> findAll();

    public Assignment findById(int id);

}
