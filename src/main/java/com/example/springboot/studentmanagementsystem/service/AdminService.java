package com.example.springboot.studentmanagementsystem.service;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.entity.Teacher;

import java.util.List;

public interface AdminService {

    public void save(Admin admin);

    public void deleteById(int id);

    public List<Admin> findAll();

    public Admin findById(int id);

}
