import {Component, OnInit} from '@angular/core';
import {HrService} from "../hr.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit{

  userId = this.router.url.split('/').pop();
  constructor(private hrService: HrService, private router: Router) {
  }

  ngOnInit(): void {
    console.log(this.userId);
  }

}
