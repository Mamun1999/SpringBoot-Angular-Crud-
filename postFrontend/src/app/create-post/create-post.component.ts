import { Component, OnInit } from '@angular/core';
import { Post } from '../Post';
import { PostServiceService } from '../post-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.css']
})
export class CreatePostComponent implements OnInit {
  post:Post=new Post();
  constructor(private postService:PostServiceService, private router:Router){

  }
   ngOnInit(): void {
    
   }
   


    savePost(){
        this.postService.createPost(this.post).subscribe((data)=>{
          this.goToPostList();
        },
      error=>console.log(error)
        
        )
    }

    goToPostList(){
      this.router.navigate([''])
    }
     
    onSubmit(){
      this.savePost();
      console.log(this.post)

    }
}
