package com.crio.coderHack.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.dto.UserScoreDTO;

@Service
public interface UserService {
public UserDTO createUser(UserDTO u);  
public List<UserDTO> findAll();  
public Optional<UserDTO> findById(String id);
public Optional<UserDTO> putScoreByUserId(UserScoreDTO userScoreDTO);
public void deleteUserById(String id);
}
