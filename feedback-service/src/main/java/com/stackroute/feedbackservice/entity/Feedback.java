package com.stackroute.feedbackservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class Feedback {
	
	  @Id
	    private String emailId;
	    private String name;
	    private String feedback;
	    private int starRating;
	    
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public Feedback(String emailId, String name, String feedback, int starRating) {
			super();
			this.emailId = emailId;
			this.name = name;
			this.feedback = feedback;
			this.starRating = starRating;
		}
		public Feedback() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getStarRating() {
			return starRating;
		}
		public void setStarRating(int starRating) {
			this.starRating = starRating;
		}
		
	        
}
