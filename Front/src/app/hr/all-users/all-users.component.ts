import { Component } from '@angular/core';
import {Table, TableModule} from 'primeng/table';
import {HrService} from "../hr.service";
import {Router} from "@angular/router";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss'],
  imports: [
    TableModule,
    ButtonModule,
    RippleModule
  ],
  standalone: true
})
export class AllUsersComponent {

  users: any;
  statuses: any[] = [];

  loading: boolean = true;

  activityValues: number[] = [0, 100];

  constructor(private hrService: HrService, private router: Router) {
  }

  ngOnInit() {

    this.hrService.allUsers().subscribe((response:any)=>{
      console.log(response);
      this.users = response;
    });

    this.loading = false;
  }

  clear(table: Table) {
    table.clear();
  }



  delete(id:any) {
    this.hrService.deleteUser(id).subscribe((users:any)=>{
      this.users = users;
    });
  }

  edit(id:any) {
    this.router.navigate(['/hr/user/'+id]);
  }
}
