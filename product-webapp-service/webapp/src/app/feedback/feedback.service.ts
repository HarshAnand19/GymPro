import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FeedbackService {
  private apiUrl = 'http://localhost:8007/api/feedback/add'; 
  private baseUrl='http://localhost:8007/api/feedback';

  constructor(private http: HttpClient) {}

  addFeedback(feedback: any): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
    };

    return this.http.post<any>(this.apiUrl, feedback, httpOptions);
  }

   getFeedbackByEmail(emailId: string) {
    return this.http.get(`${this.baseUrl}/get/${emailId}`);
  }
}



