import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';

@Component({
  selector: 'app-catchuphero',
  templateUrl: './catchuphero.component.html',
  styleUrls: ['./catchuphero.component.css']
})
export class CatchupheroComponent implements OnInit {

  constructor() { }
  public needy:any;
  ngOnInit(): void {
    this.needy=LoginComponent.needyResponse.heroes;
  }

}
