import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class NeedyService {

  constructor(
    private http:HttpClient
  ) { }

  // private static needyDetails:any;

  public addNeedy(  needy : any)
  {
    return this.http.post(`${baseUrl}/needy/`,needy);
  }
  public loginNeedy (login : any)
  {
    return this.http.post(`${baseUrl}/needy/login`,login);
  }
  public editNeedy(needy : any)
  {
    console.log('editeedy',needy);
    return this.http.put(`${baseUrl}/needy/edit/${needy.id}`,needy);
  }
  public findComponent(id : any)
  {
    return this.http.get(`${baseUrl}/needy/component/${id}`,id);
  }

  public showHero(id :any)
  {
    return this.http.get(`${baseUrl}/needy/showhero/${id}`,id);
  }
  // public getNeedyDetails(){
  //   return this.needyDetails;
  // }

  // public setNeedyDetails(){
  //   return this.needyDetails;
  // }




}
