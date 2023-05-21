package com.mamun.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.mamun.post.model.User;
@Service
public class UserService {
    
    public List<User> lists=new ArrayList<>();


  public  UserService(){
          lists.add(new User("mamun", "12345", "mamun@gmail.com"));

          lists.add(new User("naim", "1234", "naim@gmail.com"));

         
  }

  public User getUser(String username){
    return  this.lists.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
  }

  public User addUser(User user){
    lists.add(user);
    return user;
  }

  public List<User> getAllUser(){
     return this.lists;
  }
    
}
