package com.group3.issizsiniz.controller;


import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.service.UserService;
import com.group3.issizsiniz.service.requests.*;
import com.group3.issizsiniz.service.responses.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String register(@Valid @RequestBody UserRegisterRequests user) {
        return userService.register(user);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody UserLoginRequests user) {
        return userService.login(user);
    }

    @PostMapping(value = "/update")
    public String updateResume(@RequestBody UserResumeSaveRequests request, @RequestParam String email) {
        return userService.updateResume(request, email);
    }

    @PostMapping(value = "/addFavorites")
    public UserResponse addFavorites(@RequestBody UserAddFavoriteRequests request, @RequestParam String email){
        return userService.addJobPostToFavorites(request, email);
    }

    @PostMapping(value = "/applyJob")
    public UserResponse applyJob(@RequestBody UserApplyApplicationRequests request, @RequestParam String email){
        return userService.applyJobAdd(request,email);
    }

    @PostMapping(value = "/getFavorites")
    public List<JobPosts> getFavorites(@RequestBody UserGetPostRequests request){
        return userService.getFavoritesByEmail(request);
    }

    @PostMapping(value = "/getPreviousApplications")
    public List<JobPosts> getPreviousApplications(@RequestBody UserGetPostRequests request){
        return userService.getJobApplicationsByEmail(request);
    }
    @PostMapping(value = "/getResume")
    public String getResume(@RequestBody String email){
        return userService.getResume(email);
    }

}
