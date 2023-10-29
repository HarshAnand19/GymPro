import { Injectable } from '@angular/core';
import {HttpClient}  from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class RegistrationserviceService {
  constructor(private http:HttpClient) { }
 private api1="http://localhost:8082/auth/addUser";
  private api2="http://localhost:8082/auth/addAdmin";
  postuser(data:any){
      return this.http.post(this.api1,data);  
    }   
  
    postadmin(data:any){
      return this.http.post(this.api2,data);
    }
  
}
