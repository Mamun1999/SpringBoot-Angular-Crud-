import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PostServiceService } from '../post-service.service';
import { Post } from '../Post';

@Component({
  selector: 'app-update-post',
  templateUrl: './update-post.component.html',
  styleUrls: ['./update-post.component.css']
})
export class UpdatePostComponent implements OnInit {

  id:Number;
  post:any;

  constructor(private activatedRoute:ActivatedRoute, private service:PostServiceService
    ,private route:Router
    ){

  }
  ngOnInit(): void {
    this.id=this.activatedRoute.snapshot.params['id'];

    this.service.getPostById(this.id).subscribe((data)=>{
      this.post=data;
      console.log(data)
    },
    error=>console.log(error)
    )

  }

  onSubmit(){
    this.service.updatePost(this.post,this.id).subscribe((data)=>{
            this.goToPostList()
    },  error=>console.log(error)
    )
  }
  goToPostList(){
    this.route.navigate([''])
  }
}
