package com.group3.issizsiniz.service.responses;

import com.group3.issizsiniz.entity.JobPosts;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class UserResponse {
    private Long id;

    private String name;

    private String surname;

    private String resume;

    private String email;

    private List<JobPosts> previousApplications;

    private List<JobPosts> favorites;

}

