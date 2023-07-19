package com.group3.issizsiniz.util;


import com.group3.issizsiniz.entity.JobPosts;

import com.group3.issizsiniz.service.requests.UserJobPostsRequests;


public class JobPostMapper {

    public static JobPosts getJobPostById(UserJobPostsRequests jobPostsRequests) {
        JobPosts jobPosts = new JobPosts();
        jobPosts.setPost_id(jobPostsRequests.getPost_id());
        return jobPosts;
    }


}
