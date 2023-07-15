package com.group3.issizsiniz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDTO {
    private String name;
    private String surname;
    private String email;
    private String resume;
    private String password;
}
