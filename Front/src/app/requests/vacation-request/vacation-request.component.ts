import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environment/environment";
import {FormControl, FormGroup, NgForm, Validators} from "@angular/forms";
import {VaccationRequestService} from "./vaccation-request.service";

@Component({
  selector: 'app-vacation-request',
  templateUrl: './vacation-request.component.html',
  styleUrls: ['./vacation-request.component.scss']
})
export class VacationRequestComponent implements OnInit{
  constructor(private vaccationRequest: VaccationRequestService, private http: HttpClient) {
  }
  types : any;

  myForm = new FormGroup({
    type: new FormControl( '', [
      Validators.required
    ]),
    vaccationDuration: new FormControl('halfDay',[
      Validators.required
    ]),
    fromDate: new FormControl(new Date(), [
      Validators.required
    ]),
    toDate: new FormControl(new Date(new Date().getTime() + 24 * 60 * 60 * 1000), [
      Validators.required
    ])

  });

  ngOnInit(): void {
    this.http.get("api/vaccation/type/all").subscribe((vaccation:any)=>{
      this.types = vaccation;
    });
  }

  Selectedtype(){
    return this.myForm.get("type")?.value;
  }

  fromDate(){
    return this.myForm.get("fromDate")?.value;
  }

  toDate(){
    return this.myForm.get("toDate")?.value;
  }

  submit(){
    this.vaccationRequest.vaccationRequest(this.fromDate(), this.toDate(), this.Selectedtype());
  }

}
