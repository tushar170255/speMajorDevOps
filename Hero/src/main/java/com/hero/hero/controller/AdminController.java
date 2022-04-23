package com.hero.hero.controller;

import com.hero.hero.models.Admin;
import com.hero.hero.models.LoginRequestModel;
import com.hero.hero.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @PostMapping("/login")
    public Admin loginAdmin(@RequestBody LoginRequestModel request) throws Exception
    {
        return this.adminService.loginAdmin(request.getUsrName(), request.getPassword());


    }



}
