package com.group3.issizsiniz.repository;

import com.group3.issizsiniz.entity.JobPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostsRepository extends JpaRepository<JobPosts, Integer> {

}
