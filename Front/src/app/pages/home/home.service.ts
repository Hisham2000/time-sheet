import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environment/environment";
import {map} from "rxjs";
import {MessageService} from "primeng/api";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) {
  }

  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }

  signIn() {
    let defaultConfig = {
      headers: {
        'Content-Type': 'application/json;',
        'Authorization': localStorage.getItem("token") + '',
      }
    };
    console.log(localStorage.getItem('token'));
    this.http.post("api/attendant/enter", {},{headers: this.addHeaders()}).subscribe((response:any)=>{
      // this.messageService.add({ severity: 'success', summary: 'Sign In Successfully', detail: "Wlecome "+response.user.name });
    },error => {
      // this.messageService.add({ severity: 'error', summary: 'Erorr', detail: "Sorry there was an erorr please try again later" });
    });
  }

  signOut(){
    this.http.post("api/attendant/leave",{}, {headers: this.addHeaders()}).subscribe((response:any)=>{
      // this.messageService.add({ severity: 'success', summary: 'Sign Out Successfully', detail: "Bye Bye "+response.user.name });
    }, error => {
      // this.messageService.add({ severity: 'error', summary: 'Erorr', detail: "Sorry there was an erorr please try again later" });
    });
  }
}
