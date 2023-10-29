import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionupdateService {
  private apiUrl = 'http://localhost:8082/auth/update-subscription'; // Update with your actual API endpoint

  constructor(private http: HttpClient) {}

  updateSubscription(email: string, subscriptionTitle: string) {
    const requestBody = { email, subscriptionTitle };
    return this.http.post(this.apiUrl, requestBody);
  }
}
