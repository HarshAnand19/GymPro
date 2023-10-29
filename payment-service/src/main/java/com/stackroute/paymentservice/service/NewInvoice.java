package com.stackroute.paymentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Invoice;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.entity.Checkout;

@RestController
public class NewInvoice {
	
	  @Value("${razorpay.keyId}")
	    private String razorpayKeyId;

	    @Value("${razorpay.keySecret}")
	    private String razorpayKeySecret;
	
	@Autowired
	private final  CheckoutService checkoutService;
	
	
	 @Autowired
	    public NewInvoice(CheckoutService checkoutService) {
	        this.checkoutService = checkoutService;
	    }

	@PostMapping("/newInvoice")
	public String generateNewInvoice(
			String name,
			String contact,
			String email,
			int amount
			) throws RazorpayException {
		
		
		RazorpayClient razorpay = new RazorpayClient(razorpayKeyId,razorpayKeySecret);

		JSONObject invoiceRequest = new JSONObject();
		invoiceRequest.put("type", "invoice");
		invoiceRequest.put("description", "Invoice for the month of January 2020");
		invoiceRequest.put("partial_payment",true);
		JSONObject customer = new JSONObject();
		customer.put("name",name);
		customer.put("contact",contact);
		customer.put("email",email);
		
	
		invoiceRequest.put("customer",customer);
		
		List<Object> lines = new ArrayList<>();
		JSONObject lineItems = new JSONObject();
		lineItems.put("name","Master Cloud Computing in 30 Days");
		lineItems.put("description","Book by Ravena Ravenclaw");
		lineItems.put("amount", amount * 100);
		lineItems.put("currency","INR");
		lineItems.put("quantity",1);
		lines.add(lineItems);
		invoiceRequest.put("line_items",lines);
		invoiceRequest.put("email_notify", 1);
		invoiceRequest.put("sms_notify", 1);
		invoiceRequest.put("currency","INR");
		invoiceRequest.put("expire_by", 2180479824L);

		Invoice invoice = razorpay.invoices.create(invoiceRequest);
		String invoiceId = invoice.get("id").toString();
	 
		Checkout checkout = new Checkout();
		checkout.setPaymentId(invoiceId);
//		checkout.setAmount(amount);	
		checkout.setEmail(email);
        checkout.setSubscriptionId("Test");
		checkoutService.saveCheckout(checkout);
		
		return "Invoice generated successfully  and invoice id generrated :"+invoiceId;
	}
}
