import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SignupComponent } from './pages/signupneedy/signupneedy.component';
import {SignupheroComponent } from './pages/signuphero/signuphero.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignuputilComponent } from './pages/signuputil/signuputil.component';
import { NeedypageComponent } from './pages/needypage/needypage.component';
import { HeropageComponent } from './pages/heropage/heropage.component';
import { AdminpageComponent } from './pages/adminpage/adminpage.component';
import { NeedyeditprofileComponent } from './pages/needyeditprofile/needyeditprofile.component';
import { CatchupheroComponent } from './pages/catchuphero/catchuphero.component';
import { HerofeedbackComponent } from './herofeedback/herofeedback.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: "full",
  },

  {
    path:'signupneedy',
    component:SignupComponent,
    pathMatch:'full',
  },
  {
    path:'signuphero',
    component:SignupheroComponent,
    pathMatch: 'full',
  },
  {
    path: 'login',
    component:LoginComponent,
    pathMatch:'full',

  },
  {path: 'signuputil',
  component: SignuputilComponent,
  pathMatch:'full',

  },
  {
    path : 'needypage',
    component: NeedypageComponent,
    pathMatch: 'full',
  },
  {
    path : 'heropage',
    component: HeropageComponent,
    pathMatch: 'full',
  }
  ,
  {
    path : 'adminpage',
    component: AdminpageComponent,
    pathMatch: 'full',
  }
  ,
  {
    path : 'needyeditprofile',
    component:NeedyeditprofileComponent ,
    pathMatch: 'full',
  },
  {
    path:'catchuphero',
    component: CatchupheroComponent,
    pathMatch:'full'
  },
  {
    path: 'herofeedback',
    component:HerofeedbackComponent,
    pathMatch:'full'
  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
