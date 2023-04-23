import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
    items = [
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
      },
      {
        label: 'Help',
        icon: 'fas fa-question-circle'
      }
      // ,
      // {
      //   label: 'Log Out',
      //   icon: 'fas fa-sign-out '
      // }
    ];
}
