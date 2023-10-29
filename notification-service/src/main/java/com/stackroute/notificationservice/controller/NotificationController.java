package com.stackroute.notificationservice.controller;

import com.stackroute.notificationservice.model.NotificationMessage;
import com.stackroute.notificationservice.repository.NotificationRepository;
import com.stackroute.notificationservice.service.NotificationSenderService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	private final NotificationSenderService emailSenderService;
	private final NotificationRepository notificationRepository;


    public NotificationController(NotificationSenderService emailSenderService, NotificationRepository notificationRepository) {
        this.emailSenderService = emailSenderService;
        this.notificationRepository = notificationRepository;
    }

    @PostMapping("/send-email")
    public ResponseEntity <String> sendEmail(@RequestBody NotificationMessage emailMessage) {
        this.emailSenderService.sendEmail(emailMessage.getId(),emailMessage.getTo(), emailMessage.getTitle(), emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }
    
    @GetMapping("/allnotifications")
    public ResponseEntity<List<NotificationMessage>> getAllNotifications() {
        List<NotificationMessage> notifications = notificationRepository.findAll();
        return ResponseEntity.ok(notifications);
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<NotificationMessage> getNotificationById(@PathVariable int id) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            return ResponseEntity.ok(notification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/notification/{id}")
    public ResponseEntity<String> deleteNotificationById(@PathVariable int id) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notificationRepository.deleteById(id);
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/notification/{id}")
    public ResponseEntity<String> updateNotification(@PathVariable int id, @RequestBody NotificationMessage updatedNotification) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notification.setTo(updatedNotification.getTo());
            notification.setTitle(updatedNotification.getTitle());
            notification.setMessage(updatedNotification.getMessage());
            notificationRepository.save(notification);
            return ResponseEntity.ok("Updated");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}