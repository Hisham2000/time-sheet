import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-work-leave',
  templateUrl: './work-leave.component.html',
  styleUrls: ['./work-leave.component.scss']
})
export class WorkLeaveComponent {

  myform = new FormGroup({
    fromDate: new FormControl(new Date(),[
      Validators.required
    ]),
    toDate: new FormControl(new Date(new Date().getTime() + 24 * 60 * 60 * 1000),[
      Validators.required
    ])
  });

  fromDate(){
    return this.myform.get("fromDate")?.value;
  }

  toDate(){
    return this.myform.get("toDate")?.value;
  }

  submit(){

  }
}
