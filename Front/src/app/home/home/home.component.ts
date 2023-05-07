import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HomeService} from "./home.service";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],

})
export class HomeComponent implements AfterViewInit{
  constructor(private homeService: HomeService, private messageService: MessageService) {
  }
  value = 10;

  signIn() {
    this.homeService.signIn();
  }

  signOut(){
    this.homeService.signOut();
  }

  ngAfterViewInit(): void {
    this.messageService.add({ severity: 'success', summary: 'Success', detail: 'You Are Logged In Successfully' });
  }

}
