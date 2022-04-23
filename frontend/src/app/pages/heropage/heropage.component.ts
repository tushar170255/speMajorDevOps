import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { HeroService } from 'src/app/services/hero.service';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';
import { NeedypageComponent } from '../needypage/needypage.component';

@Component({
  selector: 'app-heropage',
  templateUrl: './heropage.component.html',
  styleUrls: ['./heropage.component.css']
})
export class HeropageComponent implements OnInit {
public  hero: any;
public needyToAccept : any;
public static needyFeedbackId:any;
public static needyFeedback: any;
public needyTopending :any;
  constructor(private heroService :HeroService,private router:Router) 
  {
    this.hero=LoginComponent.heroResponse;
    this.needyToAccept=this.hero.needyAccept;
  this.needyTopending=this.hero.needyPending;
    
   

   }

  ngOnInit(): void {
  

  }
accept(id : any,x:any){

  this.heroService.acceptNeedy(this.hero.id,id).subscribe(
    (data : any)=>{
      this.hero=data;
      console.log(LoginComponent.heroResponse);
      Swal.fire( {title: 'Request is Sucessfully ACCepted',
      html: "KEEP Helping ",
      text: 'Redirecting...',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{ this.ngOnInit();}
      
        });
    }
    ,(error)=>{
      console.log(error);
      alert('error occured!!!');
    }
  )




  


}
reject()
{

}
completed(x : any)
{

  this.heroService.taskCompleted(x,this.hero.id).subscribe(
   (data: any)=>{
    HeropageComponent.needyFeedbackId=x;

      Swal.fire( {title: 'GOOD JOB BAWA',
      html: "KEEP GOING",
      text: 'Please provide the feed back about the person you helped',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{this.router.navigate(["/herofeedback"])}
      })

     
   },
   (error : any)=> {
     alert('sone thig went wrong ');
   }
  )

}

}
