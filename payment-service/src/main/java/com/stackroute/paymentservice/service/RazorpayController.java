package com.stackroute.paymentservice.service;

import java.math.BigInteger;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.stackroute.paymentservice.entity.Checkout;


@RestController
@RequestMapping("/pg")
public class RazorpayController {

    private RazorpayClient client;
    private static final String SECRET_ID = "rzp_test_52bM6P4gOP3ErM";
	private static final String SECRET_KEY = "Xe305Va1UDuSY2VllGAxU0hz";

	@Autowired
	private CheckoutService service;

    @RequestMapping(path = "/createOrder", method = RequestMethod.POST)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = new OrderResponse();
        try {

            client = new RazorpayClient(SECRET_ID, SECRET_KEY);
            Order order = createRazorPayOrder(orderRequest.getAmount());
            System.out.println("---------------------------");
            String orderId = (String) order.get("id");
            System.out.println("Order ID: " + orderId);
            System.out.println("---------------------------");
            response.setRazorpayOrderId(orderId);
            response.setApplicationFee("" + orderRequest.getAmount());
                response.setSecretKey(SECRET_KEY);
                response.setSecretId(SECRET_ID);
                response.setPgName("razor1");

                String subscriptionId = UUID.randomUUID().toString();
                
                
                Checkout checkout = new Checkout();
                checkout.setPaymentId(orderId);
                checkout.setSubscriptionId(subscriptionId);
                checkout.setCustomerName(orderRequest.getCustomerName());
                checkout.setAmount(orderRequest.getAmount());
                checkout.setEmail(orderRequest.getEmail());
                checkout.setPhoneNumber(orderRequest.getPhoneNumber());
                
                service.saveCheckout(checkout);
                
            return response;
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return response;

    }

    private Order createRazorPayOrder(BigInteger amount) throws RazorpayException {

        JSONObject options = new JSONObject();
        options.put("amount", amount.multiply(new BigInteger("100")));
        options.put("currency", "INR");
        options.put("receipt", "txn_123456");
        options.put("payment_capture", 1);
        return client.orders.create(options);
    }
}