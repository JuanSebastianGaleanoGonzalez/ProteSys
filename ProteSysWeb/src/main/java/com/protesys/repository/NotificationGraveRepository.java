package com.protesys.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.protesys.utils.notifications.NotificationGrave;

@Repository
public interface NotificationGraveRepository extends CrudRepository<NotificationGrave, Long> {
    
}
