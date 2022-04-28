import { Component, OnInit } from '@angular/core';
import { NeedyService } from '../services/needy.service';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';

@Component({
  selector: 'app-needyfeedback',
  templateUrl: './needyfeedback.component.html',
  styleUrls: ['./needyfeedback.component.css']
})
export class NeedyfeedbackComponent implements OnInit {
  public heroFeedbackId:any;
  public heroFeedback: any;
  public hero : any;
  public needy : any;


  public feedback={
    comment:'',
    like:'' ,
  
  }
  constructor(private needyService:NeedyService,private router: Router) { }
  ngOnInit(): void {
    




  


  }
  submit(){
     let needyid= Number(window.localStorage.getItem("needyId"));
    let heroid=Number(window.localStorage.getItem("heroId"));
   this.needyService.taskFinished(needyid,heroid,this.feedback.like).subscribe(
     (data: any)=>
     {
      Swal.fire( {title: 'feedback is Succesfully submitted',
      html: "thank you",
      text: 'you can cath up with him later...',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{ this.router.navigate(['/needypage'])}
      
        });
     },
     (error: any)=>{
      window.alert("error occure due to your mistake you idiot??");

     }

   )


  }

}
