package com.stackroute.notificationservice.service.impl;

import com.stackroute.notificationservice.service.SMSService;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService {
	
	@Value("${twilio.account-sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth-token}")
    private String twilioAuthToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    @Override
    public String sendSMS(String id, String toPhoneNumber, String message) {
        try {
            Twilio.init(twilioAccountSid, twilioAuthToken);
            
            Message smsMessage = Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(twilioPhoneNumber),
                    message)
                    .create();

            return "SMS sent with SID: " + smsMessage.getSid();
        } catch (ApiException e) {
            return "Error sending SMS: " + e.getMessage();
        }
    }


}