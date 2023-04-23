import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-requests',
  templateUrl: './my-requests.component.html',
  styleUrls: ['./my-requests.component.scss']
})
export class MyRequestsComponent implements OnInit{

  status :any;
  color:any
  constructor(private router: Router) {
  }
    ngOnInit() {
      let segments = this.router.url.split('/');
      this.status = segments.pop();
      if(this.status == "accepted") this.color = "green";
      else if(this.status == "pending") this.color = "yellow";
      else this.color = "red";
      console.log(this.status);
    }

  navigate(accepted: string) {
    this.status = accepted;
    if(this.status == "accepted") this.color = "green";
    else if(this.status == "pending") this.color = "yellow";
    else this.color = "red";
    this.router.navigate(["/requests/my/"+accepted]);
  }
}
