package com.group3.issizsiniz.service.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
public class UserLoginRequests {

    @NotBlank(message = "E-mail can't be empty.")
    private String email;
    @NotBlank(message = "Password can't be empty.")
    private String password;
}
