package com.stackroute.notificationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.notificationservice.model.SMSEntity;
import com.stackroute.notificationservice.service.SMSService;


@RestController
@RequestMapping("/sms")
public class SMSController {
	
	private final SMSService smsService;

    @Autowired
    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSMS(@RequestBody SMSEntity smsEntity) {
        String response = smsService.sendSMS(smsEntity.getId(), smsEntity.getToPhoneNumber(), smsEntity.getMessage());
        return ResponseEntity.ok(response);
    }

}
