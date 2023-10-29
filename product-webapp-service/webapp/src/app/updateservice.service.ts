import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateserviceService {
  constructor(private http: HttpClient) {}

  updateUser(email: string, data: any, profilePicture: File): Observable<any> {
    const formData = new FormData();
  
    
    const reader = new FileReader();

    return new Observable((observer) => {
      reader.onload = (event: any) => {
        const fileByteArray = new Uint8Array(event.target.result);
        formData.append('profilePicture', new Blob([fileByteArray], { type: profilePicture.type }), profilePicture.name);
        
        // Append the user data as JSON string
        formData.append('data', JSON.stringify(data));
        
        const url = `http://localhost:8082/auth/updateUser/${email}`;
        
        this.http.put(url, formData).subscribe(
          (response) => {
            observer.next(response);
            observer.complete();
          },
          (error) => {
            observer.error(error);
          }
        );
      };
      
      reader.readAsArrayBuffer(profilePicture);
    });
  }
}
