import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErrorPageComponent} from "./error-page/error-page.component";

const routes: Routes = [
  {path: "auth", loadChildren: () => import("./auth/auth.module").then( m => m.AuthModule)},
  {path: "home", loadChildren: () => import("./home/home.module").then( m=> m.HomeModule)},
  {path: "attendance", loadChildren: () => import("./attendence/attendence.module").then(m=>m.AttendenceModule)},
  {path: "requests", loadChildren: () => import("./requests/requests.module").then(m=>m.RequestsModule)},
  {path: "", pathMatch: "full", redirectTo: "/home"},
  {path: "**", component: ErrorPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
