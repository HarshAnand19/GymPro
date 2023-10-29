import { Component } from '@angular/core';
import { EventService } from '../event.service';
import { NgForm, FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-event-register',
  templateUrl: './event-register.component.html',
  styleUrls: ['./event-register.component.css']
})
export class EventRegisterComponent {
  eventForm!: FormGroup; 

  eventData = {
    eventName: '',
    eventDate: '',
    eventLocation: '',
    eventDetails: '',
    registrationBeginsDate: '',
    registrationEndsDate: ''
  };

  constructor(private eventService: EventService, private fb: FormBuilder) {}

  ngOnInit() {
    this.eventForm = this.fb.group({
      eventName: ['', Validators.required],
      eventDate: ['', Validators.required],
      eventLocation: ['', Validators.required],
      eventDetails: ['', Validators.required],
      registrationBeginsDate: ['', Validators.required],
      registrationEndsDate: ['', Validators.required],
    }, {
      validators: this.dateValidator
    });
  }

  dateValidator(formGroup: FormGroup) {
    const eventDate = formGroup.get('eventDate')!.value; // Add '!' operator here
    const beginsDate = formGroup.get('registrationBeginsDate')!.value; // Add '!' operator here
    const endsDate = formGroup.get('registrationEndsDate')!.value; // Add '!' operator here

    if (beginsDate > eventDate || endsDate > eventDate) {
      return { dateError: true };
    }

    return null;
  }

  createEvent() {
    this.eventService.createEvent(this.eventForm.value).subscribe((response) => {
      if (response) {
        console.log('Event created:', response);

        this.eventForm.reset();

      // You can also reset the eventData object if needed
      this.eventData = {
        eventName: '',
        eventDate: '',
        eventLocation: '',
        eventDetails: '',
        registrationBeginsDate: '',
        registrationEndsDate: ''
      };
      } else {
        console.error('Event creation failed');
      }
    });
  }
}
