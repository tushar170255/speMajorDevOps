import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signupneedy/signupneedy.component';
import { FooterComponent } from './components/footer/footer.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatRadioModule} from '@angular/material/radio';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { SignupheroComponent } from './pages/signuphero/signuphero.component';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card'; 
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatIconModule} from '@angular/material/icon';
import { SignuputilComponent } from './pages/signuputil/signuputil.component';
import { NeedypageComponent } from './pages/needypage/needypage.component';
import { HeropageComponent } from './pages/heropage/heropage.component';
import { AdminpageComponent } from './pages/adminpage/adminpage.component';
import { NeedynavbarComponent } from './components/needynavbar/needynavbar.component';
import {MatMenuModule} from '@angular/material/menu';
import { NeedyeditprofileComponent } from './pages/needyeditprofile/needyeditprofile.component';
import { CatchupheroComponent } from './pages/catchuphero/catchuphero.component';
import { HeronavbarComponent } from './components/heronavbar/heronavbar.component';
import { HerofeedbackComponent } from './herofeedback/herofeedback.component';
import { NeedyfeedbackComponent } from './needyfeedback/needyfeedback.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SignupComponent,
    FooterComponent,
    SignupheroComponent,
    HomeComponent,
    SignuputilComponent,
    NeedypageComponent,
    HeropageComponent,
    AdminpageComponent,
    NeedynavbarComponent,
    NeedyeditprofileComponent,
    CatchupheroComponent,
    HeronavbarComponent,
    HerofeedbackComponent,
    NeedyfeedbackComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatRadioModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatMenuModule,
    






  ],

  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
