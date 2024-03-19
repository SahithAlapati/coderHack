package com.crio.coderHack.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.model.User;

@Service
public interface UserService {
public UserDTO createUser(User u);  
public List<User> findAll();  
}
