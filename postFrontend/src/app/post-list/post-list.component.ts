import { Component, OnInit } from '@angular/core';
import { Post } from '../Post';
import { PostServiceService } from '../post-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  posts:Post[];
  id:Number;

  constructor(private postService: PostServiceService, private activatedRoute:ActivatedRoute,
    private router:Router
    ){
   
  }

  
  ngOnInit(): void {
   this.getAllPost();
  this.id= this.activatedRoute.snapshot.params['id']
  }


  getAllPost(){
    this.postService.getPosts().subscribe((data)=>{
      this.posts=data
      console.log(data)
    },
    error=>console.log(error)
    )
  }

  // updatePost(post:Post,id:number){

  //   this.postService.updatePost(post,id).subscribe((data)=>{
  //     console.log(data)
  //   },
    
  //   error=>console.log(error)
  //   )

  // }

 

  updateButton(id:Number){
    this.router.navigate(['update',id])
  }

  deleteButton(id:Number){
    this.postService.deletePost(id).subscribe((data)=>{
      this.goToPostList();
      console.log(data)
    })

  }
  goToPostList(){
    this.router.navigate([''])
  }

  viewPost(id:Number){
    this.router.navigate(['post',id])
  }


}
