package com.group3.issizsiniz.service.responses;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserLoginResponse {
    private Long id;

    private String name;

    private String surname;

    private String resume;
}
