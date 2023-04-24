import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environment/environment";

@Component({
  selector: 'app-vacation-request',
  templateUrl: './vacation-request.component.html',
  styleUrls: ['./vacation-request.component.scss']
})
export class VacationRequestComponent implements OnInit{
  constructor(private http: HttpClient) {
  }
  types : any;
  ingredient: any = true;
  date = new Date();
  Todate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);

  ngOnInit(): void {
    this.http.get(environment.apiUrl+'vaccation/type/all').subscribe((vaccation:any)=>{
      this.types = vaccation;
    });
  }

}
