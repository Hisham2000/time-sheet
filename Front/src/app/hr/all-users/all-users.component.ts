import { Component } from '@angular/core';
import { Table } from 'primeng/table';
import {HrService} from "../hr.service";
import {Router} from "@angular/router";
@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.scss']
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
