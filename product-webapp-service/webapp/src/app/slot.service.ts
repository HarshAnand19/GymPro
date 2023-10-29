import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs'; // Import Observable from RxJS
import { Slot } from './slot.model';
import { Trainer } from './trainers.model';
@Injectable({
  providedIn: 'root'
})
export class SlotService {
  
  constructor(private http: HttpClient) {}
  
    createSlot(slotData: any) {
      return this.http.post('http://localhost:8001/api/Createslots', slotData);
    }
    
    private apiUrl = 'http://localhost:8001/api/Createslots'; 


  getSlots(): Observable<Slot[]> {
    return this.http.get<Slot[]>(this.apiUrl);
  }
    private bookApi = 'http://localhost:8001/api/slot-bookings';
  bookSlot(slotId: string, userEmail: string, bookingDate: string): Observable<any> {
    const bookUrl = `${this.bookApi}`;
  
    const bookingData = {
      slotId: slotId,
      userEmail: userEmail,
      bookingDate: bookingDate
    };

  
    return this.http.post(bookUrl, bookingData);
  }
  updateSlot(slotId: number, updatedData: any): Observable<any> {
    const updateUrl = `${this.apiUrl}/${slotId}`;
    return this.http.put<any>(updateUrl, updatedData);
  }

  deleteSlot(slotId: number): Observable<void> {
    const deleteUrl = `${this.apiUrl}/${slotId}`;
    return this.http.delete<void>(deleteUrl);
  }

  private baseUrla = 'http://localhost:8001/api/gym/trainers/all'; 

  getAllTrainers(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(`${this.baseUrla}`);
  }


  
  
  private baseUrl = 'http://localhost:8001/api/gym';
  getGymDetails(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  updateGymDetails(gymId: string, params: HttpParams): Observable<any> {
    return this.http.put(`${this.baseUrl}/update/${gymId}`, null, { params });
  }

  // editTrainerDetails(gymId: string, params: HttpParams): Observable<any> {
  //   return this.http.delete(`${this.baseUrl}/trainers/${gymId}`, { params });
  // }

  editTrainerDetails(trainerId: string, body:any): Observable<any> {
    return this.http.put(`${this.baseUrl}/trainers/${trainerId}`, body);
  }


  uploadProfilePicture(gymId: string, formData: FormData): Observable<any> {
    return this.http.post(`${this.baseUrl}/upload-picture/${gymId}`, formData);
  }

  updateProfile(gymId: string, data: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/upload-picture/${gymId}`, data);
  }

  getTrainers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/trainers/all`);
  }

  addTrainer(trainerData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/trainers/add`, trainerData);
  }

  addEquipment(equipmentData: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/equipments/add`, equipmentData);
  }

  getGymEquipments(): Observable<any> {
    return this.http.get(`${this.baseUrl}/equipments/all`);
  }

  updateGymEquipments(equipmentId: string,params: HttpParams): Observable<any> {
    return this.http.put(`${this.baseUrl}/equipments/update/${equipmentId}`,null,{ params });
  }

  deleteTrainer(TrainerId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/trainers/${TrainerId}`);
  }

  deleteEquipment(equipmentId: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/equipments/delete/${equipmentId}`);
  }
  
}
