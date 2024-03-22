package com.crio.coderHack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.dto.UserScoreDTO;
import com.crio.coderHack.exception.AlreadyPresentException;
import com.crio.coderHack.exception.NotFoundException;
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
        return userRepository.findAll().stream().map(s->modelMapper.map(s,UserDTO.class)).sorted((user1, user2)->{if(user1.getScore()!=null && user2.getScore()!=null)return user2.getScore().compareTo(user1.getScore());else return 0;}).collect(Collectors.toList());
    }

    @SuppressWarnings("null")
    @Override
    public Optional<UserDTO> findById(String id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty())
        throw new NotFoundException("User Not Found");
        return Optional.of(modelMapper.map(user.get(),UserDTO.class));
    }

    @SuppressWarnings("null")
    @Override
    public Optional<UserDTO> putScoreByUserId(UserScoreDTO userScoreDTO) {
        Optional<User> user=userRepository.findById(userScoreDTO.getId());
        if(user.isEmpty())
        throw new NotFoundException("User Not Found");
        user.get().setScore(userScoreDTO.getScore());
        user.get().setBadges(putBadgesByScore(userScoreDTO.getScore()));
        userRepository.save(user.get());
        return Optional.ofNullable(modelMapper.map(user.get(),UserDTO.class));

    }

    public List<String> putBadgesByScore(Integer score)
    {
        List<String> badges=new ArrayList<>();
        if(score>=1)
        badges.add("Code Ninja");
        if(score>=30)
        badges.add("Code Champ");
        if(score>=60)
        badges.add("Code Master");
        return badges;
    }

    @SuppressWarnings("null")
    @Override
    public void deleteUserById(String id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty())
        throw new NotFoundException("User Not Found");
        userRepository.deleteById(id);
    }

    


    
}
