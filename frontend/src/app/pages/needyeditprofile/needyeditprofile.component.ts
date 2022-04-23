import { Component, OnInit } from '@angular/core';
import {LoginComponent } from '../login/login.component';
import Swal from 'sweetalert2';
import { NeedyService } from 'src/app/services/needy.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-needyeditprofile',
  templateUrl: './needyeditprofile.component.html',
  styleUrls: ['./needyeditprofile.component.css']
})

export class NeedyeditprofileComponent implements OnInit {

  public needy:any;

  constructor(private needyService: NeedyService ,private router :Router) {
    // console.log(this.needy);
    // console.log(LoginComponent.needyResponse);
   }

  ngOnInit(): void {
    this.needy={
      usrName:LoginComponent.needyResponse.usrName,
      password:LoginComponent.needyResponse.password,
      firstName:LoginComponent.needyResponse.firstName,
      lastName:LoginComponent.needyResponse.lastName,
      sex:LoginComponent.needyResponse.sex,
      email:LoginComponent.needyResponse.email,
      phone:LoginComponent.needyResponse.phone,
      pincode:LoginComponent.needyResponse.pinCode,
      birthday:LoginComponent.needyResponse.birthday,
      age:LoginComponent.needyResponse.age,
      disable:LoginComponent.needyResponse.disable,
      disability:LoginComponent.needyResponse.disability,
      image:LoginComponent.needyResponse.image,
      address:LoginComponent.needyResponse.address,
      id:LoginComponent.needyResponse.id,
    }
    // console.log(LoginComponent.needyResponse );
  }
  onFileChanged( event: any)
  {
    this.needy.image=event.target.files[0];
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
    this.needyService.editNeedy(this.needy).subscribe(
      (data : any)=>{
            console.log(data);
          //  Swal.fire("sucess","user is registered","success",5000);
         Swal.fire( {title: 'INFORMATION is UPDATED',
        html: "profile changed...",
        timer: 4000,
        text: 'Redirecting...',
        icon: 'success',
        showConfirmButton:true,
        didClose: ()=>{this.router.navigate(['/needypage'])}
          });
        }
          ,(error)=>{
            console.log(error);
            alert('error occured!!!');
           this.router.navigate(['/needyeditprofile']);
          }


    )
   
  
    // this.needyService.addNeedy(this.needy).subscribe(
    //   (data : any)=>{
    //     console.log(data);
    //   //  Swal.fire("sucess","user is registered","success",5000);
    //  Swal.fire( {title: 'User is Successfully registered',
    // html: "You are ready to use service of our mighty heroes !! redirecting to login ....",
    // timer: 4000,
    // text: 'Redirecting...',
    // icon: 'success',
    // showConfirmButton:true,
    //   }).then(
    //     function() {
    //       window.location.href = "/login";
    //   });
    // }
    //   ,(error)=>{
    //     console.log(error);
    //     alert('error occured!!!');
    //   }
    // )
    
  }
}
