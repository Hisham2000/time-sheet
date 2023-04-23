import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MyRequestsComponent} from "./my-requests/my-requests.component";
import {VacationRequestComponent} from "./vacation-request/vacation-request.component";
import {WorkFromHomeComponent} from "./work-from-home/work-from-home.component";
import {PermissionComponent} from "./permission/permission.component";
import {WorkLeaveComponent} from "./work-leave/work-leave.component";

const routes: Routes = [
  {path: "my/:status", component: MyRequestsComponent},
  {path: "vacation", component: VacationRequestComponent},
  {path: "workfromhome", component: WorkFromHomeComponent},
  {path: "permission", component: PermissionComponent},
  {path: "workleave", component: WorkLeaveComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RequestsRoutingModule { }
