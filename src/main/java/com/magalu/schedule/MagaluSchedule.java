package com.magalu.schedule;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.magalu.service.NotificationService;

@Component
public class MagaluSchedule {
	private static final Logger logger = LoggerFactory.getLogger(MagaluSchedule.class);

	private final NotificationService service;
	
	public MagaluSchedule(NotificationService service) {
		this.service = service;
	}
	
	@Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
	public void checkTask() {
		var ldt = LocalDateTime.now();
		logger.info("teste {}", ldt);
		service.checkAndSend(ldt);
	}
	
}
