package com.stackroute.notificationservice.service;

import java.util.List;

import com.stackroute.notificationservice.model.NotificationMessage;

public interface NotificationSenderService {
	void sendEmail(int id, String to, String title, String message);
	
	public List<NotificationMessage> getAllNotifications();

	public NotificationMessage getNotificationById(int id);

	public int deleteNotificationById(int id);

	public int updateNotification(int id, NotificationMessage updatedNotification);


}