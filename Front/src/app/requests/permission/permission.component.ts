import { Component } from '@angular/core';

@Component({
  selector: 'app-permission',
  templateUrl: './permission.component.html',
  styleUrls: ['./permission.component.scss']
})
export class PermissionComponent {
  toDate: any;
  display = 'none'
  fromDate = new Date;
  hoursNumber: any;

  showDate(number: number) {
    this.display = "block";
    this.toDate = new Date(this.fromDate.getTime()+number*60*60*1000);
    this.hoursNumber = number;
  }
}
