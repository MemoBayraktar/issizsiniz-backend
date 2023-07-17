package com.group3.issizsiniz.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_posts")
public class JobPosts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private String title;
    private Date datePosted;
    private String description;
    private String location;
    private String position;
    private String workType;//hybrid, office, remote
    private String field;//sektör
    private String workHours;//full-time, part-time, Intern

    @ManyToMany
    @JoinColumn(name="user_id", referencedColumnName="ID")
    private List<User> appliers;

}
