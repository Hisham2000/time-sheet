import {environment} from "../environment";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class ServiceUrl {
  public baseUrl = '';
  public login = 'login';
  public attend = 'attendant/enter';
  public leave = 'attendant/leave';
  public getAttendanceType = 'attendance-type/all'

  constructor() {
    this.getUrl()
  }

  getUrl() {
    this.baseUrl = environment.baseUrl;
  }
}
