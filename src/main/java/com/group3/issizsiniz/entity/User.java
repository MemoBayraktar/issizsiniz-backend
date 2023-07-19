package com.group3.issizsiniz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    @NotBlank
    private String name;

    @Column(name ="surname")
    @NotBlank
    private String surname;

    @Column(name="email")
    @NotBlank
    private String email;

    @Column(name="password")
    @NotBlank
    private String password;

    @Column(name="resume")
    private String resume;

    @ManyToMany
    @JoinColumn(name="apply_id", referencedColumnName="Apply_ID")
    private List<JobPosts> previousApplications;

    @ManyToMany
    @JoinColumn(name="favorite_id", referencedColumnName = "Favorite_ID")
    private List<JobPosts> favorites;



    /*@Column(name="createdTime")
    private LocalDateTime createdTime;*/

}
