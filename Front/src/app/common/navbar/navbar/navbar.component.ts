import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

    items : any = [];

  constructor(private http: HttpClient) {
  }

  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }

  ngOnInit(): void {

    this.http.get("/api/userroles", {headers: this.addHeaders()}).subscribe((response:any)=>{
      debugger
      this.items = [
        {
          label: 'Home',
          icon: 'fas fa-home',
          routerLink: '/home'
        },
        {
          label: 'Attendance',
          icon: 'fas fa-clock',
          routerLink: '/attendance'
        },
        {
          label: 'Requests',
          icon: 'fas fa-code-pull-request',
          items: [
            {
              label: 'My requests',
              icon: 'fas fa-user',
              routerLink: '/requests/my/accepted'
            },
            {
              label: 'Vacation request',
              icon: 'fas fa-refresh',
              routerLink: '/requests/vacation'
            },
            {
              label: 'Work From Home',
              icon: 'fas fa-home',
              routerLink: '/requests/workfromhome'
            },
            {
              label: 'Permission',
              icon: 'fas fa-lock',
              routerLink: '/requests/permission'
            },
            {
              label: 'Work leave',
              icon: 'fas fa-mail-reply',
              routerLink: '/requests/workleave'
            }
          ]
        },
        {
          label: 'Setting',
          icon: 'fas fa-cog',
          routerLink: '/setting'
        },
        {
          label: 'Help',
          icon: 'fas fa-question-circle'
        },

      ];
      if(response[0].name === 'HR')
      {
        this.items.push(
          {label: 'Employees Module', icon: 'fas fa-users', items: [
              {label: 'Add employee', icon: 'fas fa-user-plus', routerLink: ['/hr/addnewemployee']},
              {label: 'All Employees', icon: 'fas fa-users', routerLink: ['/hr/allusers']}
            ]},
        );
      }else if(response[0].name === 'Manager')
      {
        this.items.push(
          {label: 'Admin MOdule'},
          {label: 'Employee Requests', icon: 'fas fa-users'},
        );
      }
    });
  }
}
