package com.group3.issizsiniz.service;
import com.group3.issizsiniz.entity.JobPosts;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.exception.InvalidRegisterException;
import com.group3.issizsiniz.exception.LoginFailedException;
import com.group3.issizsiniz.repository.UserRepository;
import com.group3.issizsiniz.service.requests.*;
import com.group3.issizsiniz.service.responses.LoginResponse;
import com.group3.issizsiniz.service.responses.UserResponse;
import com.group3.issizsiniz.util.UserMapperUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.regex.Pattern;

import static com.group3.issizsiniz.config.SecurityConfig.matchPassword;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {



    @Autowired
    private UserRepository userRepository;

    protected static PasswordEncoder passwordEncoder;




    public List<User> getAll() {

        return userRepository.findAll();
    }
    public boolean checkIfMailExists(String email){
        return userRepository.existsByEmail(email);

    }
    public String register(UserRegisterRequests request) {
        String mailAddress = request.getEmail();
        String regexPattern = "^(.+)@(.+)$";
        boolean patternMatches = Pattern.compile(regexPattern).matcher(mailAddress).matches();
        if (!checkIfMailExists(mailAddress) && patternMatches) {
            User user = UserMapperUtil.toUserForRegister(request);
            userRepository.save(user);
            return "Kayıt Başarılı";
        } else
            throw new InvalidRegisterException("Invalid register input");
    }

      /*  if(!checkIfMailExists(request.getEmail())){
            User user = UserMapperUtil.toUserForRegister(request);
            userRepository.save(user);
            return "Kayıt Başarılı";
        }
        else
            throw new InvalidRegisterException("Invalid register input");



    }*/

    public UserResponse login(UserLoginRequests request)  {


        User user = userRepository.findByEmail(request.getEmail());

        if(user != null) {
            boolean isPwdRight = matchPassword(request.getPassword(),user.getPassword());
            if (isPwdRight) {



                return UserMapperUtil.toUserResponse(user,"Success");
            } else
                throw new LoginFailedException("Invalid Email or password");

        }
        else
            throw new LoginFailedException("Invalid Email or password");

    }

    public String updateResume(UserResumeSaveRequests saveRequest, String email) {
        User byEmail = userRepository.findByEmail(email);



        User user = UserMapperUtil.forUpdateResume(saveRequest, byEmail);

        userRepository.save(user);

        return user.getResume();
    }

    public UserResponse addJobPostToFavorites(UserAddFavoriteRequests favoriteRequests, String email){
        User byEmail = userRepository.findByEmail(email);

        User user = UserMapperUtil.forUpdateFavorites(favoriteRequests,byEmail);

        userRepository.save(user);
        return UserMapperUtil.toUserResponse(user,"Success");
    }

    public UserResponse applyJobAdd(UserApplyApplicationRequests applicationRequests, String email){
        User byEmail = userRepository.findByEmail(email);
        User user = UserMapperUtil.forUpdateApplications(applicationRequests,byEmail);
        userRepository.save(user);
        return UserMapperUtil.toUserResponse(user,"Success");
    }

    public List<JobPosts> getFavoritesByEmail(UserGetPostRequests requests){
        User user = userRepository.findByEmail(requests.getEmail());

        return user.getFavorites();
    }

    public List<JobPosts> getJobApplicationsByEmail(UserGetPostRequests requests){
        User user = userRepository.findByEmail(requests.getEmail());
        return user.getPreviousApplications();
    }

    public String getResume(String email){
        User user = userRepository.findByEmail(email);
        return user.getResume();
    }




}
