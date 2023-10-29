import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthserviceService } from '../authservice.service';

import { Router } from '@angular/router';
import LoginResponse from './LoginResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  userForm!: FormGroup;

  constructor(
    private authService: AuthserviceService,
    private formBuilder: FormBuilder,
    private router: Router,
    
  ) {}

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['', Validators.required],
    });
  }

  postDetails() {
    if (this.userForm.valid) {
      const { email, password, role } = this.userForm.value;

      this.authService.login(email, password, role).subscribe(
        (res) => {
          alert('Login Successfully');
          const userEmail = (res as LoginResponse).email;
          this.router.navigate(['/home-service', userEmail]);
          this.authService.logini(userEmail);
        },
        (err) => {
          alert('Oops! Enter correct details');
        }
      );
    } else {
      alert('Enter all required fields!');
    }
  }

  register() {
    this.router.navigate(['/register']);
  }
}
