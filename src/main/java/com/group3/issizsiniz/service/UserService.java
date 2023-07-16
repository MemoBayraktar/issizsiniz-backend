package com.group3.issizsiniz.service;
import com.group3.issizsiniz.entity.User;
import com.group3.issizsiniz.repository.UserRepository;
import com.group3.issizsiniz.service.requests.UserRegisterRequests;
import com.group3.issizsiniz.service.responses.UserRegisterResponse;
import com.group3.issizsiniz.util.UserMapperUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getAll() {

        return userRepository.findAll();
    }

    public UserRegisterResponse register(UserRegisterRequests request) {
        User user = UserMapperUtil.toUser(request);
        User savedUser = userRepository.save(user);
        return UserMapperUtil.toUserResponse(savedUser);
    }

    /*public UserRegisterResponse register(){}*/






}
