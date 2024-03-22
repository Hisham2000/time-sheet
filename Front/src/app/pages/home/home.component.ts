import {AfterViewInit, Component, OnInit} from '@angular/core';
import {HomeService} from "./home.service";
import {MessageService} from "primeng/api";
import {NavbarModule} from "../../common/navbar/navbar.module";
import {ToastModule} from "primeng/toast";
import {KnobModule} from "primeng/knob";
import {FormsModule} from "@angular/forms";
import {FooterModule} from "../../common/footer/footer.module";
import {ServiceUrl} from "../../../../Utilities/ServiceUrl";
import {ServiceCall} from "../../../../Utilities/ServiceCall";

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
export class HomeComponent implements OnInit, AfterViewInit{
  attendanceTypes: any = [];
  constructor(private homeService: HomeService,
              private _serviceUrl: ServiceUrl,
              private _serviceCall: ServiceCall,
              private messageService: MessageService) {
  }

  ngOnInit(): void {
       this.getAttendanceType();
    }
  value = 10;

  signIn() {
    let type = this.attendanceTypes.find((type: any)=>{
      return type.name == "Sign In";
    });
    debugger
    let url = this._serviceUrl.baseUrl + this._serviceUrl.attend + '/' + type.id;
    this._serviceCall.postObservable(url, {}, this._serviceCall.getDefaultHeaders(null)).subscribe((response: any)=>{
      this.messageService.add({ severity: 'success', summary: 'Sign In Successfully', detail: "Welcome "+response.user.name });
    });
  }

  signOut(){
    let url = this._serviceUrl.baseUrl + this._serviceUrl.leave;
    this._serviceCall.postObservable(url, {}, this._serviceCall.getDefaultHeaders(null)).subscribe((response: any)=>{
      this.messageService.add({ severity: 'success', summary: 'Sign Out Successfully', detail: "Bye Bye "+response.user.name });
    })
  }

  ngAfterViewInit(): void {
    // this.messageService.add({ severity: 'success', summary: 'Success', detail: 'You Are Logged In Successfully' });
  }
  getAttendanceType(){
    let url = this._serviceUrl.baseUrl + this._serviceUrl.getAttendanceType;
    this._serviceCall.getOpservable(url, this._serviceCall.getDefaultHeaders(null)).subscribe((response: any)=>{
      debugger
      this.attendanceTypes = response;
    });
  }
}
