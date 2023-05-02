import { Component } from '@angular/core';
import {HomeService} from "./home.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  constructor(private homeService: HomeService) {
  }
  value = 10;

  signIn() {
    this.homeService.signIn();
  }

  signOut(){
    this.homeService.signOut();
  }
}
