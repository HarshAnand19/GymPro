import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private cardTitle = new BehaviorSubject<string>('');
  private cardText = new BehaviorSubject<string>('');
  private cardBasic = new BehaviorSubject<string>('');

  cardTitle$ = this.cardTitle.asObservable();
  cardText$ = this.cardText.asObservable();
  cardBasic$ = this.cardBasic.asObservable();

  private userEmailSubject = new Subject<string>();
  userEmail$ = this.userEmailSubject.asObservable();

  // Function to update the userEmail value
  updateUserEmail(email: string) {
    this.userEmailSubject.next(email);
  }

  private userEmail!: string;

  setUserEmail(email: string) {
    this.userEmail = email;
  }

  getUserEmail(): string {
    return this.userEmail;
  }
  constructor() {}

  setCardData(title: string, text: string, basic: string) {
    this.cardTitle.next(title);
    this.cardText.next(text);
    this.cardBasic.next(basic);
  }
}
