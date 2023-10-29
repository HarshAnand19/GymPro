import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  constructor(private http: HttpClient) { }

  getCompetitionData(emailId: string) {
    return this.http.get(`http://localhost:8013/api/participated-users/event/${emailId}`);
  }
}
