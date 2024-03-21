import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActiveSystemGuard implements CanActivate {
  constructor(private router: Router) {
  }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(localStorage.length != 0 && localStorage.getItem('token')){
      debugger
      //please make validation on token
      return true;
    }
    else{
      this.router.navigate(['/auth/login']);
      return false;
    }
  }

}
