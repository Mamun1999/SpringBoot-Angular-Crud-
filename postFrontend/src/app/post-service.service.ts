import { Injectable } from '@angular/core';
import { Post } from './Post';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostServiceService {
  private baseUrl="http://localhost:8183/api/posts";
  post:Post;
  constructor(private httpClient:HttpClient) {  }
      
   createPost(post:Post): Observable<Object>{  
    

    return this.httpClient.post(`${this.baseUrl}`,post);
   }


   getPosts(): Observable<Post[]>{  

    return this.httpClient.get<Post[]>(`${this.baseUrl}`)
   }

   updatePost(post:Post,id:Number): Observable<Object>{
    return this.httpClient.put(`${this.baseUrl}/${id}`,post)

   }

   getPostById(id:Number):Observable<Object>{
  return this.httpClient.get<Post>(`${this.baseUrl}/${id}`);

   }

   deletePost(id:Number):Observable <Object>{

    return this.httpClient.delete(`${this.baseUrl}/${id}`)
   }

}
