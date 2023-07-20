package com.group3.issizsiniz.util;

import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.exception.InvalidApplyException;
import com.group3.issizsiniz.exception.InvalidRegisterException;
import com.group3.issizsiniz.service.requests.UserAddFavoriteRequests;
import com.group3.issizsiniz.service.requests.UserApplyApplicationRequests;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.requests.UserResumeSaveRequests;
import com.group3.issizsiniz.service.responses.UserResponse;

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


    public static UserResponse toUserResponse(User user,String message) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setSurname(user.getSurname());
        userResponse.setResume(user.getResume());
        userResponse.setEmail(user.getEmail());
        userResponse.setPreviousApplications(user.getPreviousApplications());
        userResponse.setFavorites(user.getFavorites());
        userResponse.setMessage(message);

        return userResponse;
    }
    public static User forUpdateResume(UserResumeSaveRequests saveRequest, User existingUser) {
        existingUser.setResume(saveRequest.getResume());
        return existingUser;
    }
    public static User forUpdateFavorites(UserAddFavoriteRequests favoriteRequests, User existingUser){
        List<JobPosts> preFavorites = existingUser.getFavorites();
        List<JobPosts> prePreviousApplications = existingUser.getPreviousApplications();
        Long favoriteId = favoriteRequests.getFavorite().getPost_id();
        for (int i= 0; i<prePreviousApplications.size(); i++){
            if(favoriteId == prePreviousApplications.get(i).getPost_id()){
                throw new InvalidApplyException("Already applied.");
            }
        }
        preFavorites.add(getJobPostById(favoriteRequests.getFavorite()));
        List<JobPosts> newFavorites = preFavorites;
        existingUser.setFavorites(newFavorites);
        return existingUser;

    }

  /*  public boolean checkIfAppliedBefore(UserApplyApplicationRequests applicationRequests, User existingUser){
        List<JobPosts> previousApplications = existingUser.getPreviousApplications();

    }*/

    public static User forUpdateApplications(UserApplyApplicationRequests applicationRequests, User existingUser){
        JobPosts appliedJob = getJobPostById(applicationRequests.getApplication());
        Long applyId = applicationRequests.getApplication().getPost_id();
        List<JobPosts> prePreviousApplications = existingUser.getPreviousApplications();
        List<JobPosts> preFavorites = existingUser.getFavorites();
        List<JobPosts> newFavorites;
        List<JobPosts> newPreviousApplications;

        for (int i= 0; i<prePreviousApplications.size(); i++){
            if(applyId == prePreviousApplications.get(i).getPost_id()){
                throw new InvalidApplyException("Already applied");
            }
        }

        for (int i = 0; i<preFavorites.size(); i++){ //deleting from Favorite Lists
            if(applyId == preFavorites.get(i).getPost_id()){
                prePreviousApplications.add(appliedJob);
                preFavorites.remove(i);
                newFavorites = preFavorites;
                newPreviousApplications = prePreviousApplications;
                existingUser.setFavorites(newFavorites);
                existingUser.setPreviousApplications(newPreviousApplications);
                return existingUser;
            }
        }

        prePreviousApplications.add(getJobPostById(applicationRequests.getApplication()));
        newPreviousApplications = prePreviousApplications;
        existingUser.setPreviousApplications(newPreviousApplications);
        return existingUser;

    }



}
