import { HttpClient } from '@angular/common/http';
import { Component, ElementRef, Renderer2 } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FeedbackService } from '../feedback/feedback.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  userEmail!: string;
  user: any;
  
  constructor(
    private route: ActivatedRoute,
    private userService: UserService,
    private feedbackService: FeedbackService,
    private router: Router, 
  ) {}

  ngOnInit(): void {
    const userEmailParam = this.route.snapshot.paramMap.get('email');
    if (userEmailParam !== null ) {
      this.userEmail = userEmailParam;
      this.fetchUser();
    } else {
      // Handle the case where 'email' parameter is not present in the URL
      console.error('Email parameter is missing in the URL.');
    }
  }
  
  fetchUser(): void {
    this.userService.getuserById(this.userEmail)
      .subscribe((user: any) => {
        this.user = user;
      });
  }
  
  checkFeedbackStatus(): void {
    this.feedbackService.getFeedbackByEmail(this.userEmail)
      .subscribe(
        (response: any) => {
          if (response === 'Show Feedback Form') {
            // User has not given feedback, navigate to the feedback form page
            this.router.navigate(['/feedback']);
          } else if (response === 'Email not found') {
            // Email not found, redirect to the feedback page or handle it as needed
            this.router.navigate(['/feedback']);
          } else {
            // User has given feedback, perform logout or any other action
            this.performLogout();
          }
        },
        (error: any) => {
          // Handle the error here, and possibly redirect to the feedback page
          console.error('Error occurred:', error);
          this.router.navigate(['/feedback']);
        }
      );
  }
  
  performLogout(): void {
  console.log('Logout Done');
  }

  logout(): void {
    // Check conditions before logging out
    this.checkFeedbackStatus(); // You can perform additional checks here

    // Perform the logout action if conditions are met
    // For example, you can redirect to the logout page or clear user session
    // this.performLogout();
  }

}
