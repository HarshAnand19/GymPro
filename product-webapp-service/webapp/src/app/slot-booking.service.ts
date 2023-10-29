import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class SlotBookingService {
  url="http://localhost:8001/api/slot-bookings/user/";

  url2 = "http://localhost:8001/api/Createslots";

  constructor(private http:HttpClient) { }

  user(email:string) {
    return this.http.get(this.url + email);
  }

  slot(){
    return this.http.get(this.url2);
  }
}
