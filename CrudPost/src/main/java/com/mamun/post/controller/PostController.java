package com.mamun.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mamun.post.exceptions.ResourceNotFoundException;
import com.mamun.post.model.Post;
import com.mamun.post.repo.PostRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PostController {
    
    @Autowired
    private PostRepo postRepo;

@PostMapping("/posts")
public Post createPost(@RequestBody Post post){
    return this.postRepo.save(post);
}

    @GetMapping("/posts")
    public List<Post> getAllPost(){
        return this.postRepo.findAll();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id){

     Post post= this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post not found with "+id));

     return ResponseEntity.ok(post);
    }

    @PutMapping("posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post newPost){


       Post previousPost= this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post not found with "+id));
       previousPost.setTitle(newPost.getTitle());
       previousPost.setCategory(newPost.getCategory());

      Post updatedPost= this.postRepo.save(previousPost);

      return ResponseEntity.ok(updatedPost);

    }
    @DeleteMapping("posts/{id}")
    public void deletePost(@PathVariable Integer id){
      Post post=  this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("not found "+id));

      this.postRepo.delete(post);

    }
}
