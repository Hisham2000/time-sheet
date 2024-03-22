import { Routes } from '@angular/router';
import {ActiveLoginGuard} from "./guards/active-login.guard";
import {ActiveSystemGuard} from "./guards/active-system.guard";
import {IsHrGuard} from "./guards/is-hr.guard";

export const routes: Routes = [
  {path: "auth", canActivate: [ActiveLoginGuard], children: [
      {path: "login", loadComponent: () => (import('./auth/login/login.component').then(m=>m.LoginComponent))},
      {path: "", pathMatch: "full", redirectTo: '/auth/login'}
    ]},
  {path: "home", loadChildren: () => import("./home/home.module").then( m=> m.HomeModule), canActivate: [ActiveSystemGuard]},
  {path: "attendance", loadChildren: () => import("./attendence/attendence.module").then(m=>m.AttendenceModule), canActivate: [ActiveSystemGuard]},
  {path: "requests", loadChildren: () => import("./requests/requests.module").then(m=>m.RequestsModule), canActivate: [ActiveSystemGuard]},
  {path: "hr", loadChildren: () => import("./hr/hr.module").then(m=>m.HrModule), canActivate: [ActiveSystemGuard, IsHrGuard]},
  {path: "setting", loadChildren: () => import("./setting/setting.module").then(m=>m.SettingModule), canActivate: [ActiveSystemGuard]},
  {path: "", pathMatch: "full", redirectTo: "/home"},
  {path: "**", loadComponent: () => (import('./error-page/error-page.component').then(m=>m.ErrorPageComponent))}
];
