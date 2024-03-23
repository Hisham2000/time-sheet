import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SettingRoutingModule } from './setting-routing.module';
import { SettingComponent } from './setting/setting.component';
import {FooterModule} from "../common/footer/footer.module";
import {NavbarComponent} from "../common/navbar/navbar/navbar.component";


@NgModule({
  declarations: [
    SettingComponent
  ],
    imports: [
        CommonModule,
        SettingRoutingModule,
        FooterModule,
        NavbarComponent
    ]
})
export class SettingModule { }
