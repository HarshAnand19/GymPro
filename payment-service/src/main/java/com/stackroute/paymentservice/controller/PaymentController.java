package com.stackroute.paymentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.entity.Checkout;
import com.stackroute.paymentservice.exceptions.CheckoutNotFoundException;
import com.stackroute.paymentservice.exceptions.EmailNotFoundException;
import com.stackroute.paymentservice.exceptions.EmptyCheckoutException;
import com.stackroute.paymentservice.exceptions.PaymentException;
import com.stackroute.paymentservice.service.CheckoutService;
import com.stackroute.paymentservice.service.NewInvoice;
import com.stackroute.paymentservice.service.OrderRequest;
import com.stackroute.paymentservice.service.OrderResponse;
import com.stackroute.paymentservice.service.RazorpayController;

@RestController
@RequestMapping("/payments")
@CrossOrigin
public class PaymentController {
	
	  @Value("${razorpay.keyId}")
	    private String razorpayKeyId;

	    @Value("${razorpay.keySecret}")
	    private String razorpayKeySecret;
	
	    @Autowired
	    private RazorpayController razorpayController;
	    
	@Autowired    
	private final CheckoutService checkoutService;
	
	private final NewInvoice invoice;

    @Autowired
    public PaymentController(CheckoutService checkoutService, NewInvoice invoice) {
        this.checkoutService = checkoutService;
		this.invoice = invoice;
    }
    

    
    @PostMapping("/makepayment")
    public OrderResponse createRazorpayOrder(@RequestBody OrderRequest orderRequest) throws RazorpayException,PaymentException{
        
    	 try {
    		 return razorpayController.createOrder(orderRequest);        
       } catch (Exception e) {
           throw new PaymentException("Could not process your payment ");
       }
        
    }

    
    
    @GetMapping("/getall")
    public  ResponseEntity<List<Checkout>> getAll() throws EmptyCheckoutException{
    	  try {
    	        List<Checkout> checkouts = checkoutService.getAll();
    	        return new ResponseEntity<>(checkouts, HttpStatus.OK);
    	    } catch (Exception e) {
    	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	    }
    }
    
    

    
    @GetMapping("/getemail/{email}")
    public ResponseEntity<List<Checkout>> getCheckoutDetailsByEmail(@PathVariable("email") String email) throws EmailNotFoundException{
        List<Checkout> checkoutDetails = checkoutService.getCheckoutDetailsByEmail(email);
        if (checkoutDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkoutDetails, HttpStatus.OK);
    }
    
    
    
    @GetMapping("/getid/{paymentId}")
    public ResponseEntity<Checkout> getCheckoutDetailsByPaymentId(@PathVariable("paymentId") String paymentId) throws CheckoutNotFoundException {
        Optional<Checkout> checkoutDetails = Optional.of(checkoutService.getCheckoutDetailsByPaymentId(paymentId));
        if (checkoutDetails.isPresent()) {
            return new ResponseEntity<>(checkoutDetails.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
