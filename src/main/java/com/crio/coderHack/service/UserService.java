package com.crio.coderHack.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crio.coderHack.dto.UserDTO;

@Service
public interface UserService {
public UserDTO createUser(UserDTO u);  
public List<UserDTO> findAll();  
}
