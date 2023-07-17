package com.group3.issizsiniz.util;

import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.responses.UserLoginResponse;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.group3.issizsiniz.config.SecurityConfig.encodePassword;

public class UserMapperUtil {



    public static User toUserForRegister(UserRegisterRequests userRegisterRequest) {
        User user = new User();

        user.setName(userRegisterRequest.getName());
        user.setSurname(userRegisterRequest.getSurname());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());

        user.setPassword(encodePassword(userRegisterRequest.getPassword()));
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        return user;
    }


    public static UserLoginResponse toUserResponse(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setId(user.getId());
        userLoginResponse.setName(user.getName());
        userLoginResponse.setSurname(user.getSurname());
        userLoginResponse.setResume(user.getResume());
        userLoginResponse.setPhoneNumber(user.getPhoneNumber());
        userLoginResponse.setEmail(user.getEmail());
        userLoginResponse.setPreviousApplications(user.getPreviousApplications());
        userLoginResponse.setFavorites(user.getFavorites());

        return userLoginResponse;
    }
}
