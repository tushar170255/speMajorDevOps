import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';
import {HeroService} from '../../services/hero.service';

@Component({
  selector: 'app-heronavbar',
  templateUrl: './heronavbar.component.html',
  styleUrls: ['./heronavbar.component.css']
})
export class HeronavbarComponent implements OnInit {

  constructor(private router:Router ,private heroService :HeroService) { }
public hero: any;
  ngOnInit(): void {
    let username= window.localStorage.getItem('username');
    let password=window.localStorage.getItem('password');

    this.heroService.loginHero({usrName:username,password:password}).subscribe(
      (data :any)=>{
        this.hero=data;

      },
      (error : any)=>{
        window.localStorage.removeItem('username');
        window.localStorage.removeItem('password');
        window.localStorage.removeItem('type');
        
        this.router.navigate(['/login']);

      }
    )

  }
  editProfile()
  {
    this.router.navigate(['/heroeditprofile']);

  }
  logout()
  {
    window.localStorage.removeItem('username');
    window.localStorage.removeItem('password');
    window.localStorage.removeItem('type');
    Swal.fire( {title: 'User is Successfully logged out',
          html: "See you soon",
          timer: 5000,
          text: 'Redirecting...',
          icon: 'success',
          showConfirmButton:true,
          didClose:()=>{this.router.navigate([''])},
            });

  }

  catchUpNeedy()
  {
    this.router.navigate(['/catchupneedy']);
  }

}
