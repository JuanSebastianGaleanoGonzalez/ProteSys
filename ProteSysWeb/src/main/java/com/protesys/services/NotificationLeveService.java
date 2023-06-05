package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.repository.NotificationLeveRepository;
import com.protesys.utils.notifications.Notification;
import com.protesys.utils.notifications.NotificationLeve;

@Service
public class NotificationLeveService{
    
    @Autowired
    NotificationLeveRepository notificationLeveRepository;

    public List<NotificationLeve> getNotificationLeves(){
        try{
            return (List<NotificationLeve>) this.notificationLeveRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public NotificationLeve getNotificationLeve(Long id){
        try{
            return this.notificationLeveRepository.findById(id).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteNotificationLeve(Long id){
        try{
            this.notificationLeveRepository.delete(this.notificationLeveRepository.findById(id).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }


    public void createNotification(Notification notification){
        try{
            this.notificationLeveRepository.save((NotificationLeve)notification);
        }catch(PersistenceException exception){
            System.out.println(exception.getMessage());
        }
    }

    public boolean updateNotificationLeve(NotificationLeve notificationLeve){
        try{
            if(this.getNotificationLeve(notificationLeve.getIdNotification()) != null){
                this.notificationLeveRepository.save(notificationLeve);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar un nivel de notificación que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }
}
