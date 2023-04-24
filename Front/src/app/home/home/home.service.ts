import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) { }

  signIn(){
    let headers = new HttpHeaders({
      Authorization: 'Bearer '+ localStorage.getItem('token')
    });
    let options = { headers: headers };
    this.http.post('http://localhost:8080/api/attendant/enter', null,options).subscribe((res:any)=>{
      console.log(res);
    });
  }
}
