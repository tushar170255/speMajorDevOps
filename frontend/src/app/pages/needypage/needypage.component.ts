import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router'
import { HeroService } from 'src/app/services/hero.service';
import { LoginComponent } from '../login/login.component';
import {NeedyService} from  'src/app/services/needy.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-needypage',
  templateUrl: './needypage.component.html',
  styleUrls: ['./needypage.component.css']
})

export class NeedypageComponent implements OnInit {
  public hero : any;
  public needy : any;
  constructor(private heroService : HeroService,private router :Router,private needyService:NeedyService) { }
public   base: any;
public   finding:any;
public   accepted : any;
public   feedback : any;
  ngOnInit(): void {
    let username = window.localStorage.getItem('username');
    let password = window.localStorage.getItem('password');
    let type = window.localStorage.getItem('type');

    if(type=='needy'){
      this.needyService.loginNeedy({usrName:username,password:password} ).subscribe(
        (data : any)=>{
        this.needy=data;
        window.localStorage.setItem("needyId",this.needy.id);
        if(this.needy.heroCompletedId != -1)
        {
          window.localStorage.setItem("heroId",this.needy.heroCompletedId)
          this.router.navigate(['/needyfeedback']);
        }
        

        this.needyService.findComponent(this.needy.id).subscribe(
          (data:any)=>{
            console.log(data);
            if(data==1){
              this.base=true;
              this.accepted=false;
              this.finding=false;
              this.feedback=false;
              
            } 
            else if(data==2)
            {this.base=false;
              this.accepted=false;
              this.finding=true;
              this.feedback=false;
  
            }else if (data==3){
              
              this.needyService.showHero(this.needy.id).subscribe(
                (data : any)=>{
                  this.hero=data;
                  window.localStorage.setItem("heroId",this.hero.id);
                 window.localStorage.setItem('hero',JSON.stringify(this.hero));
      
                },
                (error :any)=>{
                  alert('error occured!!!');
                }
  
              )
              this.base=false;
              this.accepted=true;
              this.finding=false;
              this.feedback=false;
            }
           
  
          },
  
          (error :any)=>{
            alert('error occured!!!');
          }
        )
          

     
    
      })
    }
    else{
      this.router.navigate(['/login'])
    }





  //  console.log(NeedypageComponent.base);
  }
findHero()
{
  this.heroService.findHero(this.needy).subscribe(
    (data : any)=>{
      console.log(data);
      this.base=false;
      this.accepted=false;
    this.finding=true;
    this.feedback=false;

    //  Swal.fire("sucess","user is registered","success",5000);
   
  
    
  }
    ,(error)=>{
      console.log(error);
      alert('error occured!!!');
    }
  
  
  );



}

taskFinished( heroid : any)
{



}

taskCompleted(heroid : any )
{ 
  this.needyService.taskCompleted(heroid,this.needy.id).subscribe(
   (data: any)=>{
Swal.fire( {title: 'GOOD JOB BAWA',
      html: "KEEP GOING",
      text: 'Please provide the feed back about the person you helped',
      icon: 'success',
      showConfirmButton:true,
      didClose: ()=>{this.router.navigate(["/needyfeedback"])}
      });


  
    },
    (error : any)=>{

      window.alert("something unexpected occur...");
    }

  )

}






}
