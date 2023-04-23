import { Component } from '@angular/core';

@Component({
  selector: 'app-work-leave',
  templateUrl: './work-leave.component.html',
  styleUrls: ['./work-leave.component.scss']
})
export class WorkLeaveComponent {
  fromDate = new Date();
  toDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);
}
