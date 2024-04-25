import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrl: './edit-profile.component.css'
})
export class EditProfileComponent {
  user: any;
  currentUser: any;
  myForm!: FormGroup;
  error: string = '';

  constructor(private auth: AuthService, private router: Router,private builder: FormBuilder) {}

  ngOnInit() {
    this.currentUser = this.auth.currentUser();
    this.getUser();

    this.myForm = this.builder.group({
      firstName: this.builder.control(''),
      lastName: this.builder.control(''),
      email: this.builder.control(''),
      dob: this.builder.control(''),
      username: this.builder.control(''),
      password: this.builder.control(''),
      rePwd: this.builder.control(''),
      imagePath: this.builder.control('')
    });
  }

  getUser() {
    this.auth.getUser(this.currentUser.id).subscribe({
      next: res => {
        console.log(res);

        this.myForm.setValue({
          firstName: res.firstName,
          lastName: res.lastName,
          email: res.email,
          dob: res.dob,
          username: res.username,
          password: '',
          rePwd: '',
          imagePath: res.imagePath
        });
        
      }, error: (err: HttpErrorResponse) => {
        if (err.status === 401) {
          this.auth.logout();
          this.router.navigate(['/']);
        }
      }
    });
  }

  save() {
    console.log(this.myForm.value);
    if (this.myForm.value.password && this.myForm.value.password !== this.myForm.value.rePwd) {
      this.error = 'Passwords does not match';
    } else {
      this.error = '';
      this.auth.updateUser(this.currentUser.id, this.myForm.value).subscribe();
      this.router.navigate(['/myprofile']);
    }
  }
}
