package com.group3.issizsiniz.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    private Long id;

    private String name;

    private String username;

    private int age;

}
