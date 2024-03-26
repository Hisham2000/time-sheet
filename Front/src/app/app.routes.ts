import { Routes } from '@angular/router';
import {ActiveLoginGuard} from "./guards/active-login.guard";
import {ActiveSystemGuard} from "./guards/active-system.guard";
import {IsHrGuard} from "./guards/is-hr.guard";
import {AddNewEmployeeComponent} from "./hr/add-new-employee/add-new-employee.component";
import {AllUsersComponent} from "./hr/all-users/all-users.component";
import {EditUserComponent} from "./hr/edit-user/edit-user.component";

export const routes: Routes = [
  {path: "auth", canActivate: [ActiveLoginGuard], children: [
      {path: "login", loadComponent: () => (import('./auth/login/login.component').then(m=>m.LoginComponent))},
      {path: "", pathMatch: "full", redirectTo: '/auth/login'}
    ]},
  {path: "pages", canActivate: [ActiveSystemGuard], loadComponent: () => (import('./pages/pages.component').then(m=>m.PagesComponent)), children: [
      {path: "home", loadComponent: () => (import('./pages/home/home.component').then(m=>m.HomeComponent))},
      {path: "hr", canActivate: [ActiveSystemGuard, IsHrGuard], children: [
          {path: 'add-new-employee', loadComponent: () => (import('./hr/add-new-employee/add-new-employee.component').then(m=>m.AddNewEmployeeComponent))},
          {path: 'all-users', loadComponent: () => (import('./hr/all-users/all-users.component').then(m=>m.AllUsersComponent))},
          {path: 'user/:id', loadComponent: () => (import('./hr/edit-user/edit-user.component').then(m=>m.EditUserComponent))}
        ]},
      {path: "", pathMatch: "full", redirectTo: "/pages/home"}
    ]},
  {path: "attendance", loadChildren: () => import("./attendence/attendence.module").then(m=>m.AttendenceModule), canActivate: [ActiveSystemGuard]},
  {path: "requests", loadChildren: () => import("./requests/requests.module").then(m=>m.RequestsModule), canActivate: [ActiveSystemGuard]},
  {path: "setting", loadChildren: () => import("./setting/setting.module").then(m=>m.SettingModule), canActivate: [ActiveSystemGuard]},
  {path: "", pathMatch: "full", redirectTo: "/pages/home"},
  {path: "**", loadComponent: () => (import('./error-page/error-page.component').then(m=>m.ErrorPageComponent))}
];
