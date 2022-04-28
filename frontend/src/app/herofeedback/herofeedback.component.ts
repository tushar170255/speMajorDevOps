import { Component, OnInit } from '@angular/core';
import { HeropageComponent } from '../pages/heropage/heropage.component';
import { HeroService } from '../services/hero.service';
import { LoginComponent } from '../pages/login/login.component';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-herofeedback',
  templateUrl: './herofeedback.component.html',
  styleUrls: ['./herofeedback.component.css']
})
export class HerofeedbackComponent implements OnInit {
public needyFeedbackId:any;
public needyFeedback: any;
public feedback={
  comment:'',
  like:'' ,

}
  constructor(private heroService:HeroService ,private router :Router) { 
   
  }
  public needy: any;
  ngOnInit(): void {
    this.needyFeedbackId=Number(localStorage.getItem("needyId"));
    
   
  }
  submit()
  {
    console.log(this.feedback.like);
    this.heroService.feedback(this.needyFeedbackId,this.feedback.like).subscribe(
      (data : any)=>{
        
        
      
      Swal.fire( {title: 'feedback id Succesfully submitted',
      html: "you can catch up with him later in catch up connections section",
      text: 'THANK YOU',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{ this.router.navigate(['/heropage'])}
      
        });
         


      },
      (error:any )=>{
        alert('Something went wrong ...');
      }

    )

  }

}
