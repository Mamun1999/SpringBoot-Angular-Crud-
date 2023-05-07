import { Component, OnInit } from '@angular/core';
import { PostServiceService } from '../post-service.service';
import { ActivatedRoute } from '@angular/router';
import { Post } from '../Post';

@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrls: ['./view-post.component.css']
})
export class ViewPostComponent implements OnInit{

  id:Number;
  post:any;
  constructor(private postService:PostServiceService, private route:ActivatedRoute){

  }
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id']
    
    this.postService.getPostById(this.id).subscribe(data=>{
     this.post=data
      console.log(data)
    })
  }

}
