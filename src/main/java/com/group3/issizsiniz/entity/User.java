package com.group3.issizsiniz.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.time.LocalDateTime;


@Data
@Entity
public class User {

    @Id
    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private LocalDateTime createdTime;

}
