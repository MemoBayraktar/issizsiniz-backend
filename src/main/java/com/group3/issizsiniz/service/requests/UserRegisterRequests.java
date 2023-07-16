package com.group3.issizsiniz.service.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRegisterRequests {
    private String name;

    private String surname;

    private String email;

    private String password;
}
