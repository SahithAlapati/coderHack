package com.crio.coderHack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.model.User;
import com.crio.coderHack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public UserDTO createUser(User u)
    {
        if(userRepository.findById(u.getId()).isPresent())
        {}
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    


    
}
