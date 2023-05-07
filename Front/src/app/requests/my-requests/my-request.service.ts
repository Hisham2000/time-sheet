import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class MyRequestService {

  constructor(private http: HttpClient) { }
  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }
  userRequests(){
    return this.http.get("/api/requestDetails/all", {headers: this.addHeaders()});
  }

  pending(){
    return this.http.get("/api/requestDetails/pending", {headers: this.addHeaders()});
  }

  rejected(){
    return this.http.get("/api/requestDetails/rejected", {headers: this.addHeaders()});
  }
}
