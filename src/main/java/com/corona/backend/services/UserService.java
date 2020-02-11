package com.corona.backend.services;

import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User newUser(User user){
        userRepository.save(user);
        User newuser = userRepository.findUserByUsername(user.getUsername());
        return newuser;
    }
    public Iterable<User> allusers(){
        return userRepository.findAll();
    }

    public void DeleteUser(User user){
        userRepository.delete(user);
    }

}
