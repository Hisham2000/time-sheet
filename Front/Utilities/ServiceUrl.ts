import {environment} from "../environment";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class ServiceUrl {
  public baseUrl = '';
  public login = 'login';

  constructor() {
    this.getUrl()
  }

  getUrl() {
    this.baseUrl = environment.baseUrl;
  }
}
