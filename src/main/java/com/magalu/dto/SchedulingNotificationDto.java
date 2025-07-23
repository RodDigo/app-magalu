package com.magalu.dto;

import java.time.LocalDateTime;

import com.magalu.entity.Channel;
import com.magalu.entity.Notification;
import com.magalu.entity.Status;

public record SchedulingNotificationDto(LocalDateTime ldt, String destination, String message, Channel.Values channel) {

	public Notification toNotification() {
		return new Notification(ldt, destination, message, channel.toChannel(), Status.Values.PENDING.toStatus());
	}
	
}
