import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router'
import { HeroService } from 'src/app/services/hero.service';
import { LoginComponent } from '../login/login.component';
import {NeedyService} from  'src/app/services/needy.service';


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
  ngOnInit(): void {
    this.needy=LoginComponent.needyResponse;
      this.needyService.findComponent(this.needy.id).subscribe(
        (data:any)=>{
          if(data==1){
            this.base=true;
            
          } 
          else if(data==2)
          {
            this.finding=true;

          }else if (data==3){
            this.accepted=true;
            this.needyService.showHero(this.needy.id).subscribe(
              (data : any)=>{
                this.hero=data;
              },
              (error :any)=>{
                alert('error occured!!!');
              }

            )
          }
          

        },

        (error :any)=>{
          alert('error occured!!!');
        }
        

      )



  //  console.log(NeedypageComponent.base);
  }
findHero()
{
  this.heroService.findHero(this.needy).subscribe(
    (data : any)=>{
      console.log(data);
      this.base=false;
    this.finding=true;

    //  Swal.fire("sucess","user is registered","success",5000);
   
  
    
  }
    ,(error)=>{
      console.log(error);
      alert('error occured!!!');
    }
  
  
  );



}
}
