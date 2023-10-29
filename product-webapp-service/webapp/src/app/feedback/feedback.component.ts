import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FeedbackService } from './feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  feedback: any = { emailId: '', name: '', feedback: '', starRating: 0 }; // Initialize starRating to 0

  constructor(private feedbackService: FeedbackService) {}

  submitFeedback(feedbackForm: NgForm) {
    // Set the starRating in the feedback object
    this.feedback.starRating = this.selectedStars;

    this.feedbackService.addFeedback(this.feedback).subscribe(
      (response) => {
        console.log('Feedback posted successfully:', response);
        // Reset the form and star rating
        feedbackForm.resetForm();
        this.selectedStars = 0;
      },
      (error) => {
        console.error('Error posting feedback:', error);
      }
    );
  }

  stars: number[] = [1, 2, 3, 4, 5]; // Number of stars
  selectedStars: number = 0; // Currently selected stars

  selectStars(starCount: number): void {
    this.selectedStars = starCount;
  }
}
