import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import { HeroService } from '../services/hero.service';
import  Swal from 'sweetalert2';
@Component({
  selector: 'app-heroeditprofile',
  templateUrl: './heroeditprofile.component.html',
  styleUrls: ['./heroeditprofile.component.css']
})
export class HeroeditprofileComponent implements OnInit {
public hero : any;
  constructor(private router: Router ,private heroService :HeroService) { }

  ngOnInit(): void {
    let username=  window.localStorage.getItem('username');
    let password = window.localStorage.getItem('password');
    this.heroService.loginHero({usrName:username,password:password}).subscribe(
    (data : any)=>
    { 
      this.hero=data;

    },
    (error: any)=>
    {
      this.router.navigate(['/login']);

    }

    )

  }



onFileChanged( event: any)
{
  let reader = new FileReader();
  reader.onloadend = ()=> {
    this.hero.image=`${reader.result}`;
  }
  reader.readAsDataURL(event.target.files[0]);

}
// onFileChangedAI( event: any)
// {
//   event.target.files[0];
//   let reader = new FileReader();
//   reader.onloadend = ()=> {
//     this.hero.aadhaarImage=`${reader.result}`;
//   }
//   reader.readAsDataURL(event.target.files[0]);
// }
// onFileChangedOII( event: any)
// {
//   event.target.files[0];
//   let reader = new FileReader();
//   reader.onloadend = ()=> {
//     this.hero.otherIdentityImage=`${reader.result}`;
//   }
//   reader.readAsDataURL(event.target.files[0]);
// }

formSubmit(){
  
  this.heroService.editHeroProfile(this.hero).subscribe(
    (data: any)=>{
      Swal.fire( {title: 'personal information updated sucessfully',
      html: "Updation DONE... ",
      text: 'Redirecting...',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{ this.router.navigate(['/heropage']);}
      
        });
    }
  )


}


}
