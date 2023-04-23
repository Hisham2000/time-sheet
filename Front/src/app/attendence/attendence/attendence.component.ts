import { Component } from '@angular/core';

@Component({
  selector: 'app-attendence',
  templateUrl: './attendence.component.html',
  styleUrls: ['./attendence.component.scss']
})
export class AttendenceComponent {
  date: Date[] = [new Date("2023-04-16"), new Date("2023-04-15"), new Date("2023-04-10")];
}
