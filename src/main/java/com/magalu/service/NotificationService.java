package com.magalu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import com.magalu.repository.StatusRepository;
import org.springframework.stereotype.Service;

import com.magalu.dto.SchedulingNotificationDto;
import com.magalu.entity.Notification;
import com.magalu.entity.Status;
import com.magalu.repository.NotificationRepository;

@Service
public class NotificationService {

	private final NotificationRepository repository;
	
	public NotificationService(NotificationRepository repository, StatusRepository statusRepository) {
		this.repository = repository;
	}
	
	public void scheduleNotification(SchedulingNotificationDto dto) {
		repository.save(dto.toNotification());
	}
	
	public List<Notification> getNotification() {
		return repository.findAll();
	}
	
	public Notification getById(Long id) {
		return repository.findById(id).get();
	}
	
	public void checkAndSend(LocalDateTime  ldt) {
		var notifications = repository.findByStatusInAndLdtBefore(
				List.of(Status.Values.PENDING.toStatus(), Status.Values.ERROR.toStatus()), ldt);
		notifications.forEach(sendNotification());
	}
	
	private Consumer<Notification> sendNotification() {
		return n ->{
			n.setStatus(Status.Values.SUCCESS.toStatus());
			repository.save(n);
		};
	}
}
