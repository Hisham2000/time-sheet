import { Component } from '@angular/core';
import {NavbarModule} from "../common/navbar/navbar.module";
import {FooterModule} from "../common/footer/footer.module";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-pages',
  standalone: true,
  imports: [
    NavbarModule,
    FooterModule,
    RouterOutlet
  ],
  templateUrl: './pages.component.html',
  styleUrl: './pages.component.scss'
})
export class PagesComponent {

}
