package com.mamun.post.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mamun.post.model.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findByUsername(String username);
}
