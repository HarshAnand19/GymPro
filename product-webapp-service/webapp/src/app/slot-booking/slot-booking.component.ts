import { SlotBookComponent } from './../slot-book/slot-book.component';
import { Component, OnInit } from '@angular/core';
import { formatDate } from '@angular/common';
import { SlotBookingService } from '../slot-booking.service';

@Component({
  selector: 'app-slot-booking',
  templateUrl: './slot-booking.component.html',
  styleUrls: ['./slot-booking.component.css'],
})
export class SlotBookingComponent implements OnInit {
  title = 'slot-booking';
  users: any;
  slots: any;
  email = 'abc@abc.com';
  // userWithSlotDate=[]
  showTodayBooking: boolean = false;
  showUpcomingBooking: boolean = false;
  showExpiredBooking: boolean = false;


  constructor(private slotBooking: SlotBookingService) {  }


  ngOnInit(): void {
    console.log(this.email);
    this.slotBooking.user(this.email).subscribe((userData: any) => {
      this.users = userData;
      // console.log(this.users);
      console.log("from database users",this.users);
  
      this.slotBooking.slot().subscribe((slotData: any) => {
        this.slots = slotData;
        console.log("from database slots",this.slots);
  
        // Iterate through users and add slotDate
        this.users = this.users.map((user: any) => {
          const matchingSlot = this.slots.find((slot: any) => slot.slotId === user.slotId);
          if (matchingSlot) {
            return { ...user, 
              slotDate: matchingSlot.slotDate,
              startTime: matchingSlot.startTime,
              endTime: matchingSlot.endTime,
              trainerName: matchingSlot.trainerName };
          } else {
            return user;
          }
        });
  
        // Now each user in this.users has a slotDate property
        // console.log("changed one",this.users);
      });
    });
  }


  isToday(bookingDate: string): boolean {
    const date1 = formatDate(new Date(), "yyyy-MM-dd","en_US");
    // console.log(date1);
    const date2 = bookingDate;
    return date1 === date2;
  }
  isUpcoming(bookingDate: string): boolean {
    const today = new Date();
    const bookingDateObj = new Date(bookingDate);
    // console.log("upcoming obj", bookingDateObj)
    return bookingDateObj.getTime() > today.getTime();
  }

  isExpired(bookingDate: string): boolean {
    // const today = formatDate(new Date(),"dd-MM-yyyy","en_US");
    const today = new Date();
    // console.log("todays date",today);
    // console.log(bookingDate);
    let [day,month,year] = bookingDate.split('-')
    // console.log([day,month,year]);
    const bookingDateObj = new Date(+year,+month-1,+day);

    // const bookingDateObj= bookingDate;
    // console.log("date format:",bookingDateObj);
    return (bookingDateObj.getDate() < today.getDate() && bookingDateObj.getMonth() <= today.getMonth() && bookingDateObj.getFullYear() <= today.getFullYear());
    //return bookingDateObj < today;
  }


  toggleTodayBooking() {
    this.showTodayBooking = !this.showTodayBooking;
  }

  toggleUpcomingBooking(){
    this.showUpcomingBooking = !this.showUpcomingBooking;
  }

  toggleExpiredBooking(){
    this.showExpiredBooking = !this.showExpiredBooking;
  }
  
}
