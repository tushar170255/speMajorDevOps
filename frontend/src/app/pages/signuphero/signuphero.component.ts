import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { HeroService } from 'src/app/services/hero.service';
@Component({
  selector: 'app-signuphero',
  templateUrl: './signuphero.component.html',
  styleUrls: ['./signuphero.component.css']
})
export class SignupheroComponent implements OnInit {
public hero={
  usrName :'',
  password:'',
  firstName:'',
  lastName:'',
  sex: '',
  age:'',
  email:'',
  phone:'',
  birthday:'',
  address: '',
  pincode: '',
  servicePincode :'',
  image:'',
  aadhaar:'',
  aadhaarImage:'',
  otherIdentityImage:'',


}
  constructor(private heroService : HeroService) { }

  ngOnInit(): void {
  }
formSubmit()
{
  if(this.hero.usrName == ''|| this.hero.usrName == null)
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
if(this.hero.password.length <8)
{

Swal.fire('password is too short','Make you password strong','error');

  return;
}
const regularExpression = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
if(!regularExpression.test(String(this.hero.email).toLowerCase()))
{

Swal.fire('Email is not VALID','Check It Again...','error');

  return;
} const pattern = /^[0-9\-]*$/;
if(!pattern.test(String(this.hero.phone).toLowerCase()))
{

Swal.fire('PHONE no is invalid','Check It Again...','error');

  return;
}
this.heroService.addHero(this.hero).subscribe(
  (data : any)=>{
    console.log(data);
   Swal.fire("sucess","user is registered","success");
   
  }
  ,(error)=>{
    console.log(error);
    alert('error occured!!!');
  }
)

}
onFileChanged( event: any)
{
  this.hero.image=event.target.files[0];
}
onFileChangedAI( event: any)
{
  this.hero.aadhaarImage=event.target.files[0];
}
onFileChangedOII( event: any)
{
  this.hero.otherIdentityImage=event.target.files[0];
}


};

