import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HrService {

  constructor(private http: HttpClient) { }

  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }

  allUsers(){
    return this.http.get("/api/user/all", {headers: this.addHeaders()});
  }

  allRoles(){
    return this.http.get("/api/rolles/all", {headers: this.addHeaders()});
  }

  saveUser(name:any, email:any, phone:any, salary:any, role:any){
    let body = {
      "name": name,
      "email": email,
      "phone": phone,
      "salary": salary,
      "rolesset": role
    }
    return this.http.post("/api/register", body, {headers: this.addHeaders()}).subscribe();
  }

  deleteUser(id:any){
    return this.http.get("/api/user/"+id, {headers: this.addHeaders()});
  }

  findUser(id:any){
    return this.http.get("/api/user/edit/"+id,{headers: this.addHeaders()});
  }
}
