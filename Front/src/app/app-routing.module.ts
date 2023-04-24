import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErrorPageComponent} from "./error-page/error-page.component";
import {ActiveLoginGuard} from "./guards/active-login.guard";
import {ActiveSystemGuard} from "./guards/active-system.guard";

const routes: Routes = [
  {path: "auth", loadChildren: () => import("./auth/auth.module").then( m => m.AuthModule), canActivate: [ActiveLoginGuard]},
  {path: "home", loadChildren: () => import("./home/home.module").then( m=> m.HomeModule), canActivate: [ActiveSystemGuard]},
  {path: "attendance", loadChildren: () => import("./attendence/attendence.module").then(m=>m.AttendenceModule), canActivate: [ActiveSystemGuard]},
  {path: "requests", loadChildren: () => import("./requests/requests.module").then(m=>m.RequestsModule), canActivate: [ActiveSystemGuard]},
  {path: "", pathMatch: "full", redirectTo: "/home"},
  {path: "**", component: ErrorPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
