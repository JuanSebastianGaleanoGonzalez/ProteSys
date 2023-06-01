package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.utils.notifications.NotificationNormal;

@Repository
public interface NotificationNormalRepository extends CrudRepository<NotificationNormal, Long> {
    
}
