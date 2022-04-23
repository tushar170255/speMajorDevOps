import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import {LoginComponent } from '../../pages/login/login.component';
import { HeroneedyService } from 'src/app/services/heroneedy.service';
@Component({
  selector: 'app-needynavbar',
  templateUrl: './needynavbar.component.html',
  styleUrls: ['./needynavbar.component.css']
})
export class NeedynavbarComponent implements OnInit {

  constructor( private router :Router,private heroneedyService:HeroneedyService) { }
public  needy: any;
public  heroes: any;
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
}

  logout()
  {
    Swal.fire( {title: 'User is Successfully logged out',
          html: "See you soon",
          timer: 5000,
          text: 'Redirecting...',
          icon: 'success',
          showConfirmButton:true,
          didClose:()=>{this.router.navigate([''])},
            });

  }
  menuitem1()
  {
    this.router.navigate(['/needyeditprofile']);
  }
  menuitem2()
  {
  //   this.heroneedyService.catchUpHero(this.needy).subscribe(
  //     (data : any)=>{
  //       console.log(data);
  //       this.heroes=data.heroes;
  //       console.log(this.heroes);
      //  Swal.fire("sucess","user is registered","success",5000);
    //  Swal.fire( {title: 'User is Successfully registered',
    // html: "You are ready to use service of our mighty heroes !! redirecting to login ....",
    // timer: 4000,
    // text: 'Redirecting...',
    // icon: 'success',
    // showConfirmButton:true,
    // didClose: ()=> {this.router.navigate(['/catchuphero'])}
    //   });
    //   }
    
    //   ,(error)=>{
    //     console.log(error);
    //     alert('error occured!!!');
    //   }
    // );
    this.router.navigate(['/catchuphero']);
  }
}



    