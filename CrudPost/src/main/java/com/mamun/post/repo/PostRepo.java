package com.mamun.post.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mamun.post.model.Post;
@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {
    
}
