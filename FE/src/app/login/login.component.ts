import {Component} from '@angular/core';
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private authService: AuthService) {
  }

  login(username: string, password: string) {
    this.authService.login(username, password).subscribe(
      data => {
        sessionStorage.setItem('jwt', data.token); // Store the token
        alert("Succesfully authneticated")
      },
      error => {
        alert("Error while login")
      }
    );
  }
}
