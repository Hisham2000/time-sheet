import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SettingRoutingModule } from './setting-routing.module';
import { SettingComponent } from './setting/setting.component';
import {NavbarModule} from "../common/navbar/navbar.module";
import {FooterModule} from "../common/footer/footer.module";


@NgModule({
  declarations: [
    SettingComponent
  ],
  imports: [
    CommonModule,
    SettingRoutingModule,
    NavbarModule,
    FooterModule
  ]
})
export class SettingModule { }
