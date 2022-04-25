import { Component, OnInit } from '@angular/core';
import {HeroService} from '../../services/hero.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-catchupneedy',
  templateUrl: './catchupneedy.component.html',
  styleUrls: ['./catchupneedy.component.css']
})
export class CatchupneedyComponent implements OnInit {
public hero : any;
  constructor(private heroService :HeroService ,private router : Router) { }

  ngOnInit(): void {
    let username = window.localStorage.getItem('username');
    let password = window.localStorage.getItem('password');
    let type = window.localStorage.getItem('type');

  
      this.heroService.catchUpNeedy(username)

      .subscribe((data :any)=>{
      
        this.hero=data;
        
    
      }
    ,
     (error: any)=> {
       console.log('fucku');
      this.router.navigate(['/login'])
    }
      )

  }

  }


