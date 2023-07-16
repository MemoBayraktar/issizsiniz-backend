package com.group3.issizsiniz.controller;


import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.service.UserService;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.responses.UserRegisterResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping(value = "/register")
    public UserRegisterResponse save(@RequestBody UserRegisterRequests user) {
        return userService.register(user);
    }

}
