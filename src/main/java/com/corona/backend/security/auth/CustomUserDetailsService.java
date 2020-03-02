package com.corona.backend.security.auth;

import com.corona.backend.models.User;
import com.corona.backend.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String CustomerCode) throws UsernameNotFoundException {
        // Because we don't have a username we have to use our customer code

        if (CustomerCode.isEmpty()){
            throw new IllegalArgumentException("CustomerCode can't be empty");
        }
        User user = userRepository.findUserByCustomerCode(CustomerCode);

        return user;
    }
}
