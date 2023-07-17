package com.group3.issizsiniz.service.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Data
public class UserLoginRequests {

    @NotBlank(message = "E-mail alanı boş bırakılmamalıdır.")
    private String email;
    @NotBlank(message = "Şifre boş bırakılmamalıdır.")
    private String password;
}
