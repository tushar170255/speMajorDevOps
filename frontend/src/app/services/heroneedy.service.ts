import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class HeroneedyService {

  constructor(private http:HttpClient) { }
  public catchUpHero( needy : any)
  {
    return this.http.get(`${baseUrl}/needy/catchuphero/${needy.id}`,needy);
  }
}
