import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {formatDate} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class VaccationRequestService {

  constructor(private http: HttpClient) { }
  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }
  vaccationRequest(fromDate:any, toDate:any, vaccationType:any){
    let body = {
      "fromDay": fromDate,
      "toDay": toDate,
      "halfDayOrFullDay": 0,
      "vaccationType": vaccationType,
      "description": null,
      "requests": {"requestType": {id: 2, name: "Vacation request"}}
    }
    this.http.post("api/requestDetails/save", body, {headers: this.addHeaders()}).subscribe();
  }

  workFromHome(fromDay:any, toDay:any){
    let body = {
      "fromDay": fromDay,
      "toDay": toDay,
      "halfDayOrFullDay": 0,
      "vaccationType": null,
      "description": null,
      "requests": {"requestType": {id: 1, name: "Work From Home"}}
    }

    this.http.post("api/requestDetails/save", body, {headers: this.addHeaders()}).subscribe();
  }

  workLeave(fromDate:any, toDate:any){
    let body = {
      "fromDay": fromDate,
      "toDay": toDate,
      "halfDayOrFullDay": 0,
      "vaccationType": null,
      "description": null,
      "requests": {"requestType": {id: 4, name: "Work Leave"}}
    }
  }
}
