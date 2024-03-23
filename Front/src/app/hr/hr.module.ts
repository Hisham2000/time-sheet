import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HrRoutingModule } from './hr-routing.module';
import { AddNewEmployeeComponent } from './add-new-employee/add-new-employee.component';
import {FooterModule} from "../common/footer/footer.module";
import {InputTextareaModule} from "primeng/inputtextarea";
import { AllUsersComponent } from './all-users/all-users.component';
import {TableModule} from "primeng/table";
import {MultiSelectModule} from "primeng/multiselect";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProgressBarModule} from "primeng/progressbar";
import {DropdownModule} from "primeng/dropdown";
import {SliderModule} from "primeng/slider";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";
import { NewEmployeeComponent } from './new-employee/new-employee.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import {NavbarComponent} from "../common/navbar/navbar/navbar.component";


@NgModule({
  declarations: [
    AddNewEmployeeComponent,
    AllUsersComponent,
    NewEmployeeComponent,
    EditUserComponent
  ],
    imports: [
        CommonModule,
        HrRoutingModule,
        FooterModule,
        InputTextareaModule,
        TableModule,
        MultiSelectModule,
        FormsModule,
        ProgressBarModule,
        DropdownModule,
        SliderModule,
        ButtonModule,
        RippleModule,
        ReactiveFormsModule,
        NavbarComponent
    ]
})
export class HrModule { }
