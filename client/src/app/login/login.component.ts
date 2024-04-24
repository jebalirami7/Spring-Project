import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  public isLoginFormActive: boolean = true;

  loginForm: FormGroup;
  loginError: string = '';

  signupForm: FormGroup;
  signupError: string = ''; 

  constructor(private router: Router, private fb: FormBuilder, private auth: AuthService) {
    this.loginForm = this.fb.group({
      username: [''],
      password: ['']
    });

    this.signupForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      email: [''],
      username: [''],
      password: [''],
      dob: [''],
      role: ['ROLE_USER']
    });
  }

  signupSubmit() {
    const firstNameControl = this.signupForm.get('firstName');
    const lastNameControl = this.signupForm.get('lastName');
    const emailControl = this.signupForm.get('email');
    const usernameControl = this.signupForm.get('username');
    const passwordControl = this.signupForm.get('password');
    const dobControl = this.signupForm.get('dob');

    if (usernameControl && passwordControl && usernameControl.valid && passwordControl.valid && firstNameControl && lastNameControl && emailControl && firstNameControl.valid && lastNameControl.valid && emailControl.valid && dobControl && dobControl.valid) {
      this.signupError = '';

      this.auth.signup(this.signupForm.value).subscribe({
        next: (result) => {
          // this.router.navigate(['/login']);
          this.isLoginFormActive = true;
        },
        error: (err) => {
          this.signupError = "Erreur d'authentification";
          console.log(this.signupError);
        },
      });
      
    } else {
      this.signupError = 'Please enter valid credentials';
      console.log(this.signupError);
    }
    console.log(this.signupForm.value);
  }

  loginSubmit() {
    const usernameControl = this.loginForm.get('username');
    const passwordControl = this.loginForm.get('password');

    if (usernameControl && passwordControl && usernameControl.valid && passwordControl.valid) {
      const username = usernameControl.value;
      const password = passwordControl.value;
      this.loginError = '';

      let credentials = {
        username: username,
        password: password
      }

       this.auth.login(credentials).subscribe({
         next: (result) => {  
          this.auth.setToken(result.token);
          this.router.navigate(['/']);
         },
         error: (err) => {
          this.loginError = "Erreur d'authentification";
        },
       });
    } else {
      this.loginError = 'Please enter valid credentials';
    }
  }

  toggleForm() {
    // if (this.isLoginFormActive) {
    //   this.router.navigate(['/register']);
    // } else {
    //   this.router.navigate(['/login']);
    // }
    this.isLoginFormActive = !this.isLoginFormActive;
  }
}
