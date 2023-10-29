import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {
  events: any[] = [];
  userEmail: string = 'google@gamil.com';
  registrationStatus: { [eventId: string]: boolean } = {}; // Object to track registration status


  constructor(private http: HttpClient) { }

  ngOnInit(): void{

    this.http.get<any[]>('http://localhost:8015/api/events/upcoming').subscribe(
      (data) => {
        this.events = data;
      },
      (error) => {
        console.error('Error fetching events:', error);
      }
    );


  }

  registerForEvent(eventId: string) {

    const currentDate = new Date();

    const registrationData: {
      emailId: string;
      eventId: string;
      status: string;
      dateOfRegistration: string;
    } = {
      emailId: this.userEmail,
      eventId: eventId,
      status: 'BOOKED',
      dateOfRegistration: currentDate.toISOString(),
    };
    // const registrationData = {
    //   emailId: this.userEmail,
    //   eventId: eventId,
    //   status: 'BOOKED' // Set the initial status to 'BOOKED'
    //   dateOfRegistration: currentDate.toISOString(), // Convert to ISO format (e.g., "2023-09-21T12:34:56.789Z")
    // };

    this.http.post('http://localhost:8015/api/participated-users/register', registrationData).subscribe(
      (response) => {
        // Registration successful, you can handle any success action here
        this.registrationStatus[eventId] = true;
        console.log('Registration successful:', response);
      },
      (error) => {
        console.error('Error registering for the event:', error);
      }
    );
  }

}
