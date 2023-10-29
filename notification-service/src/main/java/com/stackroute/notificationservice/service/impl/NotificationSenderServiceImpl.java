package com.stackroute.notificationservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.stackroute.notificationservice.model.NotificationMessage;
import com.stackroute.notificationservice.repository.NotificationRepository;
import com.stackroute.notificationservice.service.NotificationSenderService;

@Service
public class NotificationSenderServiceImpl implements NotificationSenderService {
    private final JavaMailSender mailSender;
    @Autowired
    private NotificationRepository notificationRepository;

    public NotificationSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;

    }

    @Override
    public void sendEmail(int id, String to, String title, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("satyabhaskar555@gmail.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(message);
        NotificationMessage msg = new NotificationMessage();
        msg.setId(id);
        msg.setTo(to);
        msg.setTitle(title);
        msg.setMessage(message);
        notificationRepository.save(msg);
        this.mailSender.send(simpleMailMessage);
    }

    public List<NotificationMessage> getAllNotifications() {
        List<NotificationMessage> notifications = notificationRepository.findAll();
        return notifications;
    }

    public NotificationMessage getNotificationById(int id) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
            return notification;
    }

    public int  deleteNotificationById(int id) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notificationRepository.deleteById(id);
            return 1;
        } else {
            return 0;
        }
    }

    public int updateNotification(int id, NotificationMessage updatedNotification) {
        NotificationMessage notification = notificationRepository.findById(id).orElse(null);
        if (notification != null) {
            notification.setTo(updatedNotification.getTo());
            notification.setTitle(updatedNotification.getTitle());
            notification.setMessage(updatedNotification.getMessage());
            notificationRepository.save(notification);
            return 1;
        } else {
            return 0;
        }
    }

}