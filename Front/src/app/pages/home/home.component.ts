import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HomeService} from "./home.service";
import {MessageService} from "primeng/api";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {ToastModule} from "primeng/toast";
import {KnobModule} from "primeng/knob";
import {FormsModule} from "@angular/forms";
import {FooterModule} from "../../common/footer/footer.module";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  imports: [
    NavbarModule,
    ToastModule,
    KnobModule,
    FormsModule,
    FooterModule
  ],
  providers: [MessageService],
  standalone: true
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
    // this.messageService.add({ severity: 'success', summary: 'Success', detail: 'You Are Logged In Successfully' });
  }

}
