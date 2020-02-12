package com.corona.backend.services;

import com.corona.backend.dto.UserDTO;
import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Object getCurrentUser(Authentication authentication, Class returnType){
        Long getId = (Long) authentication.getDetails();
        User user = userRepository.findUserById(getId);
        if (user == null) {
            return null;
        }
        if (returnType == UserDTO.class) {
            return modelMapper.map(user, UserDTO.class);
        }
        else if (returnType == User.class)
        {
            return user;
        }
        return null;


    }

    public User newUser(User user){
        userRepository.save(user);
        User newuser = userRepository.findUserByEmail(user.getEmail());
        return newuser;
    }
    public Iterable<User> allusers(){
        return userRepository.findAll();
    }

    public void DeleteUser(User user){
        userRepository.delete(user);
    }

}
