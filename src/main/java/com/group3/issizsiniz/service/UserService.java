package com.group3.issizsiniz.service;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.exception.InvalidRegisterException;
import com.group3.issizsiniz.exception.LoginFailedException;
import com.group3.issizsiniz.repository.UserRepository;
import com.group3.issizsiniz.service.requests.UserLoginRequests;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.responses.UserLoginResponse;
import com.group3.issizsiniz.util.UserMapperUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

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
        if(!checkIfMailExists(request.getEmail())){
            User user = UserMapperUtil.toUserForRegister(request);
            userRepository.save(user);
            return "Kayıt Başarılı";
        }
        else
            throw new InvalidRegisterException("Invalid register input");



    }

    public UserLoginResponse login(UserLoginRequests request)  {


        User user = userRepository.findByEmail(request.getEmail());

        if(user != null) {
            Boolean isPwdRight = matchPassword(request.getPassword(),user.getPassword());
            if (isPwdRight) {
                return UserMapperUtil.toUserResponse(user);
            } else
                throw new LoginFailedException("Invalid Email");
        }
        else
            throw new LoginFailedException("Invalid Password");

    }


}
