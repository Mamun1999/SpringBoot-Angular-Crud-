package com.mamun.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamun.post.model.User;
import com.mamun.post.service.UserService;
// @CrossOrigin(origins = "*")
@RestController
@EnableMethodSecurity
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

   // @PreAuthorize("hasRole('NORMAL')")
@PostMapping("/add")
public User addUser(@RequestBody User user){
    this.userService.addUser(user);
    return user;
    
}


//@PreAuthorize("hasRole('NORMAL')")
@GetMapping("/get")
public List<User> getAllUser(){
   List<User> lists= this.userService.getAllUser();

   return lists;
}


}
