import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-homelander',
  templateUrl: './homelander.component.html',
  styleUrls: ['./homelander.component.css'],
})
export class HomelanderComponent implements OnInit {
  feedbackData: any[] = []; 

  currentFeedback = 0; 
  displayFeedback = 'block'; 

  constructor(private feedbackService: FeedbackService, private router: Router) {} 

  ngOnInit(): void {
    
    this.feedbackService.getFeedbackData().subscribe(data => {
      this.feedbackData = data;
      this.rotateFeedback();
    });
  }

  rotateFeedback() {
    setInterval(() => {
      this.currentFeedback = (this.currentFeedback + 1) % this.feedbackData.length;
    }, 5000);
  }

  redirectToLogin() {
    console.log("login......")
    this.router.navigate(['/log-in']); 
  }
  redirectToRegister(){
    this.router.navigate(['/registration']); 
  }
}
