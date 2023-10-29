import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class AuthserviceService {
  constructor(private http: HttpClient) {}
  private api = 'http://localhost:8080/api/v1/auth/login';
  private userEmail: string | null = null;

  // Simulate user login and set the user's email
  logini(email: string) {
    this.userEmail = email;
  }

  login(email: string, password: string, role: string) {
    const data = { email, password, role }; 
    return this.http.post(this.api, data);
  }
  getUserEmail(): string | null {
    return this.userEmail;
  }
}






 
 
