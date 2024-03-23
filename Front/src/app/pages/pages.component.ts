import { Component } from '@angular/core';
import {FooterModule} from "../common/footer/footer.module";
import {RouterOutlet} from "@angular/router";
import {NavbarComponent} from "../common/navbar/navbar/navbar.component";

@Component({
  selector: 'app-pages',
  standalone: true,
  imports: [
    FooterModule,
    RouterOutlet,
    NavbarComponent
  ],
  templateUrl: './pages.component.html',
  styleUrl: './pages.component.scss'
})
export class PagesComponent {

}
