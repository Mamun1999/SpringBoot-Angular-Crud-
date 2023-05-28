import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl="http://localhost:8183";

  credentials={
    username:'',
    password:''
  }
  constructor( private http:HttpClient) { }

  //fetching token from server

  generateToken(credentials:any): Observable<Object>{
    return this.http.post(`${this.baseUrl}/token`, credentials)
  }

  getToken(){
   return localStorage.getItem('token')
  }

  login(token){
    localStorage.setItem("token", token)
    return true
  }

  isLoggedin(){
   let token= localStorage.getItem("token")
   if(token==='' || token==null || token==undefined){
    return false
   }
   else{
    return true;
   }
  }

  logout(){
    localStorage.removeItem("token")
    return true;
  }
}
