import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostListComponent } from './post-list/post-list.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { UpdatePostComponent } from './update-post/update-post.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ViewPostComponent } from './view-post/view-post.component';

const routes: Routes = [

{
  path:'post/:id',
  component:ViewPostComponent
},
  {
    path: '',
    component:PostListComponent
  },
  {
    path: 'create',
    component: CreatePostComponent
    
  },
  {
    path: 'update/:id',
    component:UpdatePostComponent

  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
