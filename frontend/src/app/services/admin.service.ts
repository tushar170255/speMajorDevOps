import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor( private http : HttpClient ) { }
  public loginAdmin(login : any)
  {
    return this.http.post(`${baseUrl}/admin/login`,login);

  }
  
}
