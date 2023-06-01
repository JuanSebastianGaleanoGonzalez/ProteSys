package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.utils.notifications.NotificationLeve;

@Repository
public interface NotificationLeveRepository extends CrudRepository<NotificationLeve, Long> {
    
}
