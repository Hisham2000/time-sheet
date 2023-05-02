import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AttendenceService {

  constructor(private http: HttpClient) { }
  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }
  attendence() {
    return this.http.get("api/attendant/user", {headers: this.addHeaders()});
  }
}
