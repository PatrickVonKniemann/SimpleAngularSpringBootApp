import {CanActivate, CanActivateFn, Router} from '@angular/router';
import {Injectable} from "@angular/core";


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(): boolean {
    const token = sessionStorage.getItem('jwt');
    if (token) {
      return true; // User is authenticated
    }
    this.router.navigate(['/login']); // Redirect to login page
    return false; // User is not authenticated
  }
}
