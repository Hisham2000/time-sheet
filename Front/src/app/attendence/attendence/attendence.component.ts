import {Component, OnInit} from '@angular/core';
import {AttendenceService} from "../attendence.service";

@Component({
  selector: 'app-attendence',
  templateUrl: './attendence.component.html',
  styleUrls: ['./attendence.component.scss']
})
export class AttendenceComponent implements OnInit{
  date: Date[] = [];

  constructor(private attendenceService: AttendenceService) {
  }
  ngOnInit(): void {
    this.attendenceService.attendence().subscribe((dates:any)=>{
      for (let i = 0; i < dates.length; i++) {
        this.date.push(new Date( dates[i] ));
      }
    });
  }


}
