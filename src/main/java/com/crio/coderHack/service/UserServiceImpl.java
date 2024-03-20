package com.crio.coderHack.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.exception.AlreadyPresentException;
import com.crio.coderHack.model.User;
import com.crio.coderHack.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    

    @SuppressWarnings("null")
    @Override
    public UserDTO createUser(UserDTO u)
    {
        if(userRepository.findById(u.getId()).isPresent())
        {
            throw new AlreadyPresentException("A user with the same ID is already present!");
        }
        User user=modelMapper.map(u,User.class);
        return modelMapper.map(userRepository.save(user),UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper=new ModelMapper();
        return userRepository.findAll().stream().map(s->modelMapper.map(s,UserDTO.class)).collect(Collectors.toList());
    }

    


    
}
