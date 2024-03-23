import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AttendenceRoutingModule } from './attendence-routing.module';
import { AttendenceComponent } from './attendence/attendence.component';
import {CalendarModule} from "primeng/calendar";
import {FormsModule} from "@angular/forms";
import {FooterModule} from "../common/footer/footer.module";
import {NavbarComponent} from "../common/navbar/navbar/navbar.component";


@NgModule({
  declarations: [
    AttendenceComponent
  ],
    imports: [
        CommonModule,
        AttendenceRoutingModule,
        CalendarModule,
        FormsModule,
        FooterModule,
        NavbarComponent
    ]
})
export class AttendenceModule { }
