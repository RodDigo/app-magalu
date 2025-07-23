-- `db-magalu`.tb_channel definition

CREATE TABLE `tb_channel` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `db-magalu`.tb_notification_seq definition

CREATE TABLE `tb_notification_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `db-magalu`.tb_status definition

CREATE TABLE `tb_status` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `db-magalu`.tb_notification definition

CREATE TABLE `tb_notification` (
  `id` bigint NOT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `ldt` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `channel_id` bigint DEFAULT NULL,
  `status_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `notification_channel` (`channel_id`),
  KEY `notification_status` (`status_id`),
  CONSTRAINT `notification_channel` FOREIGN KEY (`channel_id`) REFERENCES `tb_channel` (`id`),
  CONSTRAINT `notification_status` FOREIGN KEY (`status_id`) REFERENCES `tb_status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


