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
  color:any;
  req_status:any;
  constructor(private router: Router, private myRequestService: MyRequestService) {
  }
    ngOnInit() {
      let segments = this.router.url.split('/');
      this.myRequestService.userRequests().subscribe((response:any)=>{
        console.log(response);
        this.requests = response;
      });
      this.req_status = "accepted";
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
        this.requests = response;
      });
    }
    else if(this.status == "pending")
    {
      this.myRequestService.pending().subscribe((response:any)=>{
        this.req_status = "pending";
        this.requests = response
      });
      this.color = "yellow";
    }
    else
    {
      this.myRequestService.rejected().subscribe((response:any)=>{
        console.log(response);
        this.req_status = "rejected";
        this.requests = response
      });
        this.color = "red";
    }
    this.router.navigate(["/requests/my/"+accepted]);
  }
}
