import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import {NeedyService} from '../../services/needy.service';
import {Router} from '@angular/router';



@Component({
  selector: 'app-catchuphero',
  templateUrl: './catchuphero.component.html',
  styleUrls: ['./catchuphero.component.css']
})
export class CatchupheroComponent implements OnInit {

  constructor(private needyService: NeedyService,private router :Router) { }
  public needy:any;
  ngOnInit(): void {
    let username = window.localStorage.getItem('username');
    let password = window.localStorage.getItem('password');
    let type = window.localStorage.getItem('type');

  
      this.needyService.catchUpHeroes(username)

      .subscribe((data :any)=>{
      
        this.needy=data;
        
    
      }
    ,
     (error: any)=> {
       console.log('fucku');
      this.router.navigate(['/login'])
    }
      )

  }

  }


