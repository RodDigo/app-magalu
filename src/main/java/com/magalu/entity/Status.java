package com.magalu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

	@Id
	private Long id;
	private String description;
	
	public enum Values {
		PENDING(1L, "pending"),
		SUCCESS(2L, "success"),
		ERROR(3L, "error"),
		CANCELED(4L, "canceled");
		
		@Getter
		private Long id;
		@Getter
		private String description;
		
		Values(Long id, String description) {
			this.id = id;
			this.description = description;
		}
		
		public Status toStatus() {
			return new Status(id, description);
		}
		
	}
	
}
