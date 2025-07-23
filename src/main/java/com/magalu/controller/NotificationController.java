package com.magalu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magalu.dto.SchedulingNotificationDto;
import com.magalu.entity.Notification;
import com.magalu.service.NotificationService;


@RestController
@RequestMapping(path = "/api/notification", produces = { MediaType.APPLICATION_JSON_VALUE })
public class NotificationController {

	@Autowired
	NotificationService service;
	
	@PostMapping
	public ResponseEntity<Void> createNotification(@RequestBody SchedulingNotificationDto dto) {
		service.scheduleNotification(dto);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Notification>> getNotification() {
		return ResponseEntity.ok().body(service.getNotification());
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Notification> getNotification(@PathVariable("id") Long id) {
		var notificacao = service.getById(id);
		if(notificacao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(service.getById(id));
	}
}
