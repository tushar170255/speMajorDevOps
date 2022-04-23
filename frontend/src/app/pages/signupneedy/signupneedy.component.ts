import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NeedyService } from 'src/app/services/needy.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signupneedy.component.html',
  styleUrls: ['./signupneedy.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private needyService: NeedyService ,private snack:MatSnackBar,private router: Router) { }

  ngOnInit(): void {
  }
  public needy={
    usrName:'',
    password:'',
    firstName:'',
    lastName:'',
    sex:'',
    email:'',
    phone:'',
    pincode:'',
    birthday:'',
    age:'',
    disable:'',
    disability:'',
    image:'',
    address:'',


  }
formSubmit()
{
  
  console.log(this.needy);
  //validation of various fields:
  if(this.needy.usrName == ''|| this.needy.usrName == null)
  {
  // window.alert('user is required');
  //  this.snack.open("username is required !!","",{
  //   duration: 3000,
  //  verticalPosition: 'top',
  //    horizontalPosition: 'left',


     
  //  });
  Swal.fire('UserName is Required','can not be left empty!!','error');
  
    return;
  }
  if(this.needy.password.length <8)
  {
  
  Swal.fire('password is too short','Make you password strong','error');
  
    return;
  }
  const regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  if(!regularExpression.test(String(this.needy.email).toLowerCase()))
  {
  
  Swal.fire('Email is not VALID','Check It Again...','error');
  
    return;
  } const pattern = /^[0-9\-]*$/;
  if(!pattern.test(String(this.needy.phone).toLowerCase()))
  {
  
  Swal.fire('PHONE no is invalid','Check It Again...','error');
  
    return;
  }
 

  this.needyService.addNeedy(this.needy).subscribe(
    (data : any)=>{
      console.log(data);
    //  Swal.fire("sucess","user is registered","success",5000);
   Swal.fire( {title: 'User is Successfully registered',
  html: "You are ready to use service of our mighty heroes !! redirecting to login ....",
  timer: 4000,
  text: 'Redirecting...',
  icon: 'success',
  showConfirmButton:true,
  didClose: ( )=>{this.router.navigate(['/login'])},
    } );
  
    
  }
    ,(error)=>{
      console.log(error);
      alert('error occured!!!');
    }
  );
  

}
onFileChanged( event: any)
{
  this.needy.image=event.target.files[0];
}
}
