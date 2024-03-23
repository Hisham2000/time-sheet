import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RequestsRoutingModule } from './requests-routing.module';
import { MyRequestsComponent } from './my-requests/my-requests.component';
import { VacationRequestComponent } from './vacation-request/vacation-request.component';
import {FooterModule} from "../common/footer/footer.module";
import {DropdownModule} from "primeng/dropdown";
import {RadioButtonModule} from "primeng/radiobutton";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CalendarModule} from "primeng/calendar";
import { WorkFromHomeComponent } from './work-from-home/work-from-home.component';
import { PermissionComponent } from './permission/permission.component';
import {InputTextareaModule} from "primeng/inputtextarea";
import { WorkLeaveComponent } from './work-leave/work-leave.component';
import {NavbarComponent} from "../common/navbar/navbar/navbar.component";


@NgModule({
  declarations: [
    MyRequestsComponent,
    VacationRequestComponent,
    WorkFromHomeComponent,
    PermissionComponent,
    WorkLeaveComponent
  ],
    imports: [
        CommonModule,
        RequestsRoutingModule,
        FooterModule,
        DropdownModule,
        RadioButtonModule,
        FormsModule,
        CalendarModule,
        InputTextareaModule,
        ReactiveFormsModule,
        NavbarComponent
    ]
})
export class RequestsModule { }
