import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AddNewEmployeeComponent} from "./add-new-employee/add-new-employee.component";
import {AllUsersComponent} from "./all-users/all-users.component";
import {EditUserComponent} from "./edit-user/edit-user.component";

const routes: Routes = [
  {path: 'addnewemployee', component: AddNewEmployeeComponent},
  {path: 'allusers', component: AllUsersComponent},
  {path: 'user/:id', component: EditUserComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HrRoutingModule { }
