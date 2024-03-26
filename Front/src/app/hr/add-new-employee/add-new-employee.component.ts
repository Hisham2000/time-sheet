import {Component, OnInit} from '@angular/core';
import {HrService} from "../hr.service";
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {InputTextareaModule} from "primeng/inputtextarea";
import {DropdownModule} from "primeng/dropdown";
import {ServiceUrl} from "../../../../Utilities/ServiceUrl";
import {ServiceCall} from "../../../../Utilities/ServiceCall";
import Swal from 'sweetalert2'

@Component({
  selector: 'app-add-new-employee',
  templateUrl: './add-new-employee.component.html',
  styleUrls: ['./add-new-employee.component.scss'],
  imports: [
    ReactiveFormsModule,
    InputTextareaModule,
    DropdownModule
  ],
  standalone: true
})
export class AddNewEmployeeComponent implements OnInit{
  constructor(private hrService: HrService,
              private _serviceUrl: ServiceUrl,
              private _serviceCall: ServiceCall) {
  }

  myform = new FormGroup({
    name: new FormControl('',[
      Validators.required,
      Validators.minLength(8)
    ]),
    email: new FormControl('',[
      Validators.required,
      Validators.email
    ]),
    role: new FormControl('', [
      Validators.required
    ]),
    salary: new FormControl('', [
      Validators.required
    ]),
    phone: new FormControl('',[
      Validators.required,
      Validators.maxLength(11),
      Validators.minLength(11)
    ])
  });
  roles: any;

  ngOnInit(): void {
    this.getRoles();
  }

  getRoles(){
    let url = this._serviceUrl.baseUrl + this._serviceUrl.getAllRoles;
    this._serviceCall.getOpservable(url, this._serviceCall.getDefaultHeaders(null)).subscribe((response: any)=>{
      this.roles = response;
    });
  }

  getName(){
    return this.myform.get("name")?.value;
  }

  getEmail(){
    return this.myform.get("email")?.value;
  }

  getSalary(){
    return Number(this.myform.get("salary")?.value);
  }

  getRole(){
    return Number((this.myform.get("role")?.value as any)?.id ?? null);
  }

  getPhone(){
    return this.myform.get("phone")?.value;
  }

  submit() {
    let body = {
      "name": this.getName(),
      "email": this.getEmail(),
      "roleId": this.getRole(),
      "salary": this.getSalary(),
      "phone": this.getPhone()
    }
    let url = this._serviceUrl.baseUrl + this._serviceUrl.saveNewEmployee;
    this._serviceCall.postObservable(url, body, this._serviceCall.getDefaultHeaders(null)).subscribe((response: any)=>{
      Swal.fire({
        title: "Employee added successfully",
        icon: 'success',
        width: '500px',
        confirmButtonText: "Close"
      })
    });
    this.myform.reset();
  }
}
