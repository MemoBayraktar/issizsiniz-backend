package com.group3.issizsiniz.controller;


import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.service.JobPostsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/jobposts")
@AllArgsConstructor
public class JobPostsContoller {
    @Autowired
    private JobPostsService jobPostsService;

    @GetMapping
    public List<JobPosts> getAll(){
        return jobPostsService.getAll();
    }

    @GetMapping("/filter")
    public List<JobPosts> filterJobPosts(@RequestParam(required = false) String cityFilter,
                                         @RequestParam(required = false) String workTypeFilter,
                                         @RequestParam(required = false) String fieldFilter,
                                         @RequestParam(required = false) String workHoursFilter) {
        return jobPostsService.filterJobPosts(cityFilter, workTypeFilter, fieldFilter, workHoursFilter);
    }
}
