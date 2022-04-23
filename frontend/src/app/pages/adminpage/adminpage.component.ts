import { Component, OnInit } from '@angular/core';
import {LoginComponent} from '../login/login.component';
@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {
  private adminResponse: any;
  constructor() {
    this.adminResponse = LoginComponent.adminResponse;
    console.log("In admin page",LoginComponent.adminResponse)
   }

  ngOnInit(): void {
  }

}
