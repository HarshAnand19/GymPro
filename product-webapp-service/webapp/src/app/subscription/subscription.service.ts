import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  private baseUrl = 'http://localhost:8001/api/gym/'; // Replace with your API endpoint

  constructor(private http: HttpClient) {}

  getAllSubscriptions(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl + 'subscriptions/all');
  }
}
