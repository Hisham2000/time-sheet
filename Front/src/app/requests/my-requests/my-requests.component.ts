import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MyRequestService} from "./my-request.service";

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.scss']
})
export class MyRequestsComponent implements OnInit{

  status :any;
  color:any
  constructor(private router: Router, private myRequestService: MyRequestService) {
  }
    ngOnInit() {
      let segments = this.router.url.split('/');
      this.myRequestService.userRequests().subscribe((response:any)=>{
        console.log(response);
        this.requests = response;
      });
      this.status = segments.pop();
      if(this.status == "accepted") this.color = "green";
      else if(this.status == "pending") this.color = "yellow";
      else this.color = "red";
    }

  requests:any;

  navigate(accepted: string) {
    this.status = accepted;
    if(this.status == "accepted")
    {
      this.color = "green";
      this.myRequestService.userRequests().subscribe((response:any)=>{
        console.log(response);
        this.requests = response;
      });
    }
    else if(this.status == "pending")
    {
      this.color = "yellow";
    }
    else
    {
      this.color = "red";
    }
    this.router.navigate(["/requests/my/"+accepted]);
  }
}
