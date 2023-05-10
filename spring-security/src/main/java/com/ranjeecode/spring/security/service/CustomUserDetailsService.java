package com.ranjeecode.spring.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username.equals("ranjeet")){
            return new User("ranjeet","ranjeet",new ArrayList<>());
        }else {
            throw new UsernameNotFoundException("User Not Found");
        }
    }
}
