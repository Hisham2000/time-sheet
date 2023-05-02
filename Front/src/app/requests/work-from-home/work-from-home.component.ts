import { Component } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {VaccationRequestService} from "../vacation-request/vaccation-request.service";

@Component({
  selector: 'app-work-from-home',
  templateUrl: './work-from-home.component.html',
  styleUrls: ['./work-from-home.component.scss']
})
export class WorkFromHomeComponent {

  constructor(private requestService: VaccationRequestService) {
  }

  myForm = new FormGroup({
    fromDate: new FormControl(new Date(), [
      Validators.required
    ]),
    toDate: new FormControl(new Date(new Date().getTime() + 24 * 60 * 60 * 1000), [
      Validators.required
    ])

  });

  fromDate(){
    return this.myForm.get("fromDate")?.value;
  }

  toDate(){
    return this.myForm.get("toDate")?.value;
  }

  submit() {
    this.requestService.workFromHome(this.fromDate(), this.toDate());
  }
}
