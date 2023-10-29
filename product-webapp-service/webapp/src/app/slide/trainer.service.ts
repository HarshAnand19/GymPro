import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {
  private baseUrl = 'http://localhost:8001/api/gym/trainers';
  
  constructor(private http: HttpClient) {}

  getAllTrainers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/all`);
  }

}
