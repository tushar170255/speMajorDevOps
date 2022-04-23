import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'

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
    this.router.navigate(['']);

  }

}
