package com.group3.issizsiniz.util;

import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.responses.UserRegisterResponse;

import java.time.LocalDateTime;

public class UserMapperUtil {
    public static User toUser(UserRegisterRequests userRegisterRequest) {
        User user = new User();

        user.setName(userRegisterRequest.getName());
        user.setSurname(userRegisterRequest.getSurname());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());



        return user;
    }

    public static UserRegisterResponse toUserResponse(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setName(user.getName());
        userRegisterResponse.setSurname(user.getSurname());
        userRegisterResponse.setResume(user.getResume());

        return userRegisterResponse;
    }
}
