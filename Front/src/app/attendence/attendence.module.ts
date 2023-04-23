import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AttendenceRoutingModule } from './attendence-routing.module';
import { AttendenceComponent } from './attendence/attendence.component';
import {NavbarModule} from "../common/navbar/navbar.module";
import {CalendarModule} from "primeng/calendar";
import {FormsModule} from "@angular/forms";
import {FooterModule} from "../common/footer/footer.module";


@NgModule({
  declarations: [
    AttendenceComponent
  ],
    imports: [
        CommonModule,
        AttendenceRoutingModule,
        NavbarModule,
        CalendarModule,
        FormsModule,
        FooterModule
    ]
})
export class AttendenceModule { }
