package com.group3.issizsiniz.util;

import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.service.requests.UserFavoriteRequests;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.requests.UserResumeSaveRequests;
import com.group3.issizsiniz.service.responses.UserLoginResponse;

import java.util.List;

import static com.group3.issizsiniz.config.SecurityConfig.encodePassword;
import static com.group3.issizsiniz.util.JobPostMapper.getJobPostById;

public class UserMapperUtil {



    public static User toUserForRegister(UserRegisterRequests userRegisterRequest) {
        User user = new User();

        user.setName(userRegisterRequest.getName());
        user.setSurname(userRegisterRequest.getSurname());
        user.setEmail(userRegisterRequest.getEmail());
        //user.setPassword(userRegisterRequest.getPassword());
        user.setPassword(encodePassword(userRegisterRequest.getPassword()));

        return user;
    }


    public static UserLoginResponse toUserResponse(User user) {
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setId(user.getId());
        userLoginResponse.setName(user.getName());
        userLoginResponse.setSurname(user.getSurname());
        userLoginResponse.setResume(user.getResume());
        userLoginResponse.setEmail(user.getEmail());
        userLoginResponse.setPreviousApplications(user.getPreviousApplications());
        userLoginResponse.setFavorites(user.getFavorites());

        return userLoginResponse;
    }
    public static User forUpdateResume(UserResumeSaveRequests saveRequest, User existingUser) {
        existingUser.setResume(saveRequest.getResume());
        return existingUser;
    }
    public static User forUpdateFavorites(UserFavoriteRequests favoriteRequests, User existingUser){
        List<JobPosts> preFavorites = existingUser.getFavorites();
        preFavorites.add(getJobPostById(favoriteRequests.getFavorite()));
        List<JobPosts> newFavorites = preFavorites;
        existingUser.setFavorites(newFavorites);
        return existingUser;

    }

}
