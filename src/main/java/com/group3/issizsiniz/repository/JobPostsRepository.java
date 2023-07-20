package com.group3.issizsiniz.repository;

import com.group3.issizsiniz.entity.JobPosts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostsRepository extends JpaRepository<JobPosts, Long> {
    @Query("SELECT j FROM JobPosts j WHERE " +
            "(:locationFilter IS NULL OR j.location = :locationFilter) " +
            "AND (:workTypeFilter IS NULL OR j.workType = :workTypeFilter) " +
            "AND (:fieldFilter IS NULL OR j.field = :fieldFilter) " +
            "AND (:workHoursFilter IS NULL OR j.workHours = :workHoursFilter)")
    List<JobPosts> findByFilters(
            @Param("locationFilter") String locationFilter,
            @Param("workTypeFilter") String workTypeFilter,
            @Param("fieldFilter") String fieldFilter,
            @Param("workHoursFilter") String workHoursFilter
    );
    @Query("Select j from JobPosts j where j.location like %:filter% or j.position like %:filter% or j.companyName like %:filter%")
    List<JobPosts> findBySearch(
            @Param("filter") String filter
    );




}
