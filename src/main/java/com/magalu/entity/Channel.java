package com.magalu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_channel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Channel {
	@Id
	private Long id;
	private String description;
	
	public enum Values {
		EMAIL(1l, "email"),
		SMS(2l, "sms"),
		PUSH(3l, "push"),
		WHATSAPP(4l, "whatsapp");
		
		@Getter
		private Long id;
		@Getter
		private String description;
		
		Values(Long id, String description) {
			this.id  = id;
			this.description = description;
		}
		
		public Channel toChannel() {
			return new Channel(id, description);
		}
	}
	
}
