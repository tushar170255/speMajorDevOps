import { Component, OnInit } from '@angular/core';
import { HeroService } from 'src/app/services/hero.service';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

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
  {}

  ngOnInit(): void {
    let username = window.localStorage.getItem('username');
    let password = window.localStorage.getItem('password');
    let type = window.localStorage.getItem('type');

    if(type=='hero'){
      this.heroService.loginHero({usrName:username,password:password})
      .subscribe(data=>{
        this.hero=data;
        this.needyToAccept=this.hero.needyAccept;
        this.needyToAccept.forEach((element: { image: any; }) => {
          console.log(element.image);         
        });
        this.needyTopending=this.hero.needyPending;
    
      })
    }
    else{
      this.router.navigate(['/login'])
    }

  }
accept(id : any,x:any){

  this.heroService.acceptNeedy(this.hero.id,id).subscribe(
    (data : any)=>{
      this.hero=data;
      Swal.fire( {title: 'Request is Sucessfully Accepted',
      html: "Keep Helping ",
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
    window.localStorage.setItem("needyId",x);

      Swal.fire( {title: 'GOOD JOB BAWA',
      html: "KEEP GOING",
      text: 'Please provide the feed back about the person you helped',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{this.router.navigate(["/herofeedback"])}
      })

     
   },
   (error : any)=> {
     alert('some thig went wrong ');
   }
  )

}

}
