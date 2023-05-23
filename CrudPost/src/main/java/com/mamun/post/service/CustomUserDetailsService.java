package com.mamun.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mamun.post.model.CustomUserDetails;
import com.mamun.post.model.User;
import com.mamun.post.repo.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user =  this.userRepo.findByUsername(username);

     if(user==null){
      throw new UsernameNotFoundException("User not authorized");
     }

     return new CustomUserDetails(user);

       
    }
    
}
