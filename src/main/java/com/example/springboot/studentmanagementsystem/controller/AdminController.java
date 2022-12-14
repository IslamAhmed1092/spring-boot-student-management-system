package com.example.springboot.studentmanagementsystem.controller;


import com.example.springboot.studentmanagementsystem.entity.Admin;
import com.example.springboot.studentmanagementsystem.exception.NotFoundException;
import com.example.springboot.studentmanagementsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/admins")
    public List<Admin> viewAllAdmins() {
        return adminService.findAll();
    }

    @GetMapping("/admins/{adminId}")
    public Admin getAdmin(@PathVariable int adminId) {
        Admin admin = adminService.findById(adminId);

        if(admin == null) {
            throw new NotFoundException("Admin id not found - " + adminId);
        }

        return admin;
    }

    @PostMapping("/admins")
    public Admin addAdmin(@RequestBody Admin admin) {

        admin.setId(0);

        adminService.save(admin);

        return admin;
    }

    @PutMapping("/admins")
    public Admin updateAdmin(@RequestBody Admin admin) {
        Admin dbAdmin = adminService.findById(admin.getId());

        if(dbAdmin == null) {
            throw new NotFoundException("Admin id not found - " + admin.getId());
        }

        adminService.save(admin);
        return admin;
    }

    @DeleteMapping("/admins/{adminId}")
    public String removeAdmin(@PathVariable int adminId) {
        Admin admin = adminService.findById(adminId);

        if(admin == null) {
            throw new NotFoundException("Admin id not found - " + adminId);
        }

        adminService.deleteById(adminId);

        return "Deleted Admin id - " + adminId;
    }
}
