package com.magalu.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_notification")
@Data
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private LocalDateTime ldt;
	
	private String destination;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "channel_id")
	private Channel channel;
	
	@ManyToOne
	@JoinColumn(name = "status_id")	
	private Status status;
	
	
}
