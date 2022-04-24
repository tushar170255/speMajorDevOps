import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-heronavbar',
  templateUrl: './heronavbar.component.html',
  styleUrls: ['./heronavbar.component.css']
})
export class HeronavbarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
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

}
