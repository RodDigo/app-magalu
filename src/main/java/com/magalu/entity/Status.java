package com.magalu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_status")
@Data
public class Status {

	@Id
	private Long id;
	
	private String description;
	
}
