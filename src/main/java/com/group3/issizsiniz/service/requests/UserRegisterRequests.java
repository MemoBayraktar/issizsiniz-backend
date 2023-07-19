package com.group3.issizsiniz.service.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
public class UserRegisterRequests {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min = 6, message = "Şifre 6 harften uzun olmalıdır.")
    private String password;

}
