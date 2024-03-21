import { Component } from '@angular/core';
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {ServiceUrl} from "../../../../Utilities/ServiceUrl";
import {ServiceCall} from "../../../../Utilities/ServiceCall";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {

  constructor(private authService: AuthService,
              private router: Router,
              private _serviceUrl: ServiceUrl,
              private _serviceCall: ServiceCall) {
  }
  email: any;
  password: any;
  loading: boolean = false;
  NotFound: any = false;

  myForm = new FormGroup({
    email: new FormControl(null,[
      Validators.required,
      Validators.email
    ]),
    password: new FormControl(null,[
      Validators.required,
      Validators.minLength(9)
    ])
  });

  load() {
    this.loading = true;

    setTimeout(() => {
      this.loading = false
    }, 2000);
  }

  submit() {
    // this.authService.login(this.myForm.get("email")?.value+"", this.myForm.get("password")?.value+"");
    // if(localStorage.length == 0 ) {
    //   this.NotFound = true;
    // }
    // else{
    //   this.NotFound = false;
    // }
    let url = this._serviceUrl.baseUrl + this._serviceUrl.login;
    let body = {
      "email": this.myForm.get("email")?.value+"",
      "password": this.myForm.get("password")?.value+""
    };
    this._serviceCall.postObservable(url, body, {}).subscribe((response:any)=>{
      localStorage.setItem("token", 'Bearer '+response.token);
      this.router.navigate(['/home']);
    });
  }
}
