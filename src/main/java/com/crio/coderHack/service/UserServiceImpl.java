package com.crio.coderHack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.model.User;
import com.crio.coderHack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    

    @Override
    public UserDTO createUser(User u)
    {
        if(userRepository.findById(u.getId()).isPresent())
        {
            
        }
        return modelMapper.map(userRepository.save(u),UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper=new ModelMapper();
        return userRepository.findAll().stream().map(s->modelMapper.map(s,UserDTO.class)).collect(Collectors.toList());
    }

    


    
}
