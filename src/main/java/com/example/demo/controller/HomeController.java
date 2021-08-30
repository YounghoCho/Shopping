package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(){
        return "접속";
    }

    @PostMapping("/")
    public void join(){
        userService.join();
    }

    @GetMapping("/getUser")
    public UserDto getUser(@RequestParam String name){
        return userService.getUser(name);
    }
}
