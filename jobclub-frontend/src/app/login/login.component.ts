import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  username: string = '';
  password: string = '';

  loginObj ={
    email: '',
    password: ''
  }

  constructor(private router: Router, private authService: AuthService) {}

  login() {
    // Perform authentication logic (e.g., validate username and password)
    // For simplicity, let's assume the login is successful
    // Redirect to the navigation page
    this.loginObj.email = this.username;
    this.loginObj.password = this.password;
    this.authService.login(this.loginObj).subscribe((res: any)=>{
       localStorage.setItem('token', res.token); // Store the JWT in local storage   
    })

    this.router.navigate(['/navigation']);
  }

}
