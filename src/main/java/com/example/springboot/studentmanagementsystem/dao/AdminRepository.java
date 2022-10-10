package com.example.springboot.studentmanagementsystem.dao;

import com.example.springboot.studentmanagementsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
