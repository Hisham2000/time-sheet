import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router, RouterOutlet} from "@angular/router";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [CommonModule, RouterOutlet]
})
export class AppComponent implements OnInit {
  title = 'Front';

  constructor(private http: HttpClient, private router: Router) {
  }
  addHeaders() {
    return new HttpHeaders({
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,HEAD,OPTIONS',
      'Authorization': localStorage.getItem('token')+'',
    });
  }
  ngOnInit(): void {
    if (localStorage.length > 0 && localStorage.getItem("token")) {
      this.http.get("/api/gettokendate", {headers: this.addHeaders()}).subscribe((res: any) => {
      }, error => {
        localStorage.clear();
        this.router.navigate(['/auth/login']);
      });
    }

  }

}
