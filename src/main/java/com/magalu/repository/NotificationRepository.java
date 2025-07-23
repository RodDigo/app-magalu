package com.magalu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magalu.entity.Notification;
import com.magalu.entity.Status;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByStatusInAndLdtBefore(List<Status> status, LocalDateTime ldt);
}
