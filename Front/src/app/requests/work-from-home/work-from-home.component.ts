import { Component } from '@angular/core';

@Component({
  selector: 'app-work-from-home',
  templateUrl: './work-from-home.component.html',
  styleUrls: ['./work-from-home.component.scss']
})
export class WorkFromHomeComponent {
  fromDate = new Date();
  toDate = new Date(new Date().getTime() + 24 * 60 * 60 * 1000);

}
