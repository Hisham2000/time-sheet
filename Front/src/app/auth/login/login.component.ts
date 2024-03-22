import { Component } from '@angular/core';
import {FormControl, FormGroup, NgForm, ReactiveFormsModule, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {ServiceUrl} from "../../../../Utilities/ServiceUrl";
import {ServiceCall} from "../../../../Utilities/ServiceCall";
import {ButtonModule} from "primeng/button";
import {InputTextModule} from "primeng/inputtext";
import {NgIf} from "@angular/common";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  imports: [
    ReactiveFormsModule,
    ButtonModule,
    InputTextModule,
    NgIf
  ],
  standalone: true
})
export class LoginComponent {

  constructor(private router: Router,
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
    let url = this._serviceUrl.baseUrl + this._serviceUrl.login;
    let body = {
      "email": this.myForm.get("email")?.value+"",
      "password": this.myForm.get("password")?.value+""
    };
    this._serviceCall.postObservable(url, body, {}).subscribe((response:any)=>{
      localStorage.setItem("token", 'Bearer '+response.token);
      this.router.navigate(['/pages']);
    });
  }
}
