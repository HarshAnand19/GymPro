package com.stackroute.adminservice.gym.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="subscription_plans")
public class Subscription {

	  @Id
	    private String subscriptionId;

	    private String subscriptionName;
	    private List<SubscriptionDetail> subscriptionDetails; // List of points
	    private int subscriptionPrice;
	    private String duration;
	    
	    
		public String getSubscriptionId() {
			return subscriptionId;
		}
		public void setSubscriptionId(String subscriptionId) {
			this.subscriptionId = subscriptionId;
		}
		public String getSubscriptionName() {
			return subscriptionName;
		}
		public void setSubscriptionName(String subscriptionName) {
			this.subscriptionName = subscriptionName;
		}
		public List<SubscriptionDetail> getSubscriptionDetails() {
			return subscriptionDetails;
		}
		public void setSubscriptionDetails(List<SubscriptionDetail> subscriptionDetails) {
			this.subscriptionDetails = subscriptionDetails;
		}
		public int getSubscriptionPrice() {
			return subscriptionPrice;
		}
		public void setSubscriptionPrice(int subscriptionPrice) {
			this.subscriptionPrice = subscriptionPrice;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public Subscription(String subscriptionId, String subscriptionName,
				List<SubscriptionDetail> subscriptionDetails, int subscriptionPrice, String duration) {
			super();
			this.subscriptionId = subscriptionId;
			this.subscriptionName = subscriptionName;
			this.subscriptionDetails = subscriptionDetails;
			this.subscriptionPrice = subscriptionPrice;
			this.duration = duration;
		}
		public Subscription() {
			super();
			// TODO Auto-generated constructor stub
		}
	

	
}
