package com.example.springbootsecurity.auth;


import com.example.springbootsecurity.entity.User;
import com.example.springbootsecurity.repository.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepostory userRepostory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user = userRepostory.findByName(username).orElseThrow(()->new UsernameNotFoundException("user not found"));

        return new CustomUserDetails(user);
    }
}
