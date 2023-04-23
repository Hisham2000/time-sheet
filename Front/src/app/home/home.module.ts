import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import {NavbarModule} from "../common/navbar/navbar.module";
import {FooterModule} from "../common/footer/footer.module";
import {KnobModule} from "primeng/knob";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    HomeComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    NavbarModule,
    FooterModule,
    KnobModule,
    FormsModule
  ]
})
export class HomeModule { }
