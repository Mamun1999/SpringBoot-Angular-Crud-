import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostListComponent } from './post-list/post-list.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UpdatePostComponent } from './update-post/update-post.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ViewPostComponent } from './view-post/view-post.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [

{
  path:'post/:id',
  component:ViewPostComponent
  ,
  canActivate: [AuthGuard]
},
{
   path: 'login',
   component: LoginComponent
},
  {
    path: 'post',
    component:PostListComponent,
    pathMatch: 'full',
    canActivate: [AuthGuard]
  },
  {
    path: 'create',
    component: CreatePostComponent,
    canActivate: [AuthGuard]
    
  },
  {
    path: 'update/:id',
    component:UpdatePostComponent,
    canActivate: [AuthGuard]

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
