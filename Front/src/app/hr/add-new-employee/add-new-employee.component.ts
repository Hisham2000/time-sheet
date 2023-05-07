import {Component, OnInit} from '@angular/core';
import {HrService} from "../hr.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-new-employee',
  templateUrl: './add-new-employee.component.html',
  styleUrls: ['./add-new-employee.component.scss']
})
export class AddNewEmployeeComponent implements OnInit{
  constructor(private hrService: HrService) {
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
    this.hrService.allRoles().subscribe((roles:any)=>{
      this.roles = roles;
    });
  }

  getName(){
    return this.myform.get("name")?.value;
  }

  getEmail(){
    return this.myform.get("email")?.value;
  }

  getSalary(){
    return this.myform.get("salary")?.value;
  }

  getrole(){
    let converRoleToArray = [];
    converRoleToArray.push(this.myform.get("role")?.value);
    return converRoleToArray;
  }

  getPhone(){
    return this.myform.get("phone")?.value;
  }

  submit() {
    //put a pop up on success scenario
    this.hrService.saveUser(this.getName(), this.getEmail(), this.getPhone(), this.getSalary(), this.getrole());
  }
}
