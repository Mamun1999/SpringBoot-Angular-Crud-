import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreatePostComponent } from './create-post/create-post.component';
import { UpdatePostComponent } from './update-post/update-post.component';
import { PostListComponent } from './post-list/post-list.component';
import { ViewPostComponent } from './view-post/view-post.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './auth.interceptor';







@NgModule({
  declarations: [
    AppComponent,
    CreatePostComponent,
    UpdatePostComponent,
    PostListComponent,
    ViewPostComponent,
    NavbarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [
   {
    provide:HTTP_INTERCEPTORS, useClass:AuthInterceptor,multi:true
   }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
