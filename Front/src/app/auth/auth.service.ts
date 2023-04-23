import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../environment/environment";
import {catchError, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) {
  }

  login(email: string, password: string) {

    let body = {
      "email": email,
      "password": password
    };

    this.http.post(environment.apiUrl + "login", body, {responseType: 'text'}).pipe(
      catchError(error => {
        localStorage.clear();
        console.log(localStorage.length);
        console.log("from Error");
        return throwError('Token Not Found');
      })
    ).subscribe(response => {
      localStorage.setItem("token", response);
      console.log(localStorage.length);
      console.log("from subscripe");
    });

    if (localStorage.length >= 1) return true;
    else return false;

  }

  getTheEndOfTheToken() {

    if (localStorage.getItem('token')) {
      let httpOptions = {
        headers: new HttpHeaders({
          'Authorization': 'Bearer ' + localStorage.getItem('token')
        })
      };
      return this.http.get(environment.apiUrl + 'gettokendate', httpOptions);
    }
    return null;
  }

}
