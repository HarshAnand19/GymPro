package com.stackroute.paymentservice.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Checkout_Tbl")
public class Checkout {
	
	@Id
	private String paymentId;
	private String customerName;
	private String phoneNumber;
	private BigInteger  amount;
    private String email;
    private LocalDateTime dateOfPayment= LocalDateTime.now();
    private String subscriptionId;

    public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public BigInteger getAmount() {
		return amount;
	}
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
	public LocalDateTime getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(LocalDateTime dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public String getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	public Checkout(String paymentId, String customerName, String email, String phoneNumber, BigInteger amount,
			LocalDateTime dateOfPayment, String subscriptionId) {
		super();
		this.paymentId = paymentId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.amount = amount;
		this.dateOfPayment = dateOfPayment;
		this.subscriptionId = subscriptionId;
	}
	
	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
}
