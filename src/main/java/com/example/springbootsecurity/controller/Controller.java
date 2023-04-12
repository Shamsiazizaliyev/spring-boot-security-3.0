package com.example.springbootsecurity.controller;




import com.example.springbootsecurity.entity.User;
import com.example.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class Controller {



    @Autowired
    UserService service;

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String user(){

        return "user";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(){

        return "admin";
    }

    @PostMapping("/new")

    public String addNewUser(@RequestBody User user){

        return service.addUser(user);
    }





}



