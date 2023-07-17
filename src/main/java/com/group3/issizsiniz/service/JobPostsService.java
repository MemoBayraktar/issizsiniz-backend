package com.group3.issizsiniz.service;


import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.repository.JobPostsRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JobPostsService {

    @Autowired
    private JobPostsRepository jobPostsRepository;

    public List<JobPosts> getAll(){
        return jobPostsRepository.findAll();
    }

    public List<JobPosts> filterJobPosts(String cityFilter, String workTypeFilter, String fieldFilter, String workHoursFilter) {
        return jobPostsRepository.findByFilters(cityFilter, workTypeFilter, fieldFilter, workHoursFilter);
    }
}
