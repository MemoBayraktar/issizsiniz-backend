package com.group3.issizsiniz.service.responses;

import com.group3.issizsiniz.entity.JobPosts;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Data
public class UserLoginResponse {
    private Long id;

    private String name;

    private String surname;

    private String resume;

    private String email;

    private List<JobPosts> previousApplications;

    private List<JobPosts> favorites;

    private boolean isLoggedIn;

}

