package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.repository.NotificationNormalRepository;
import com.protesys.utils.notifications.Notification;
import com.protesys.utils.notifications.NotificationNormal;

@Service
public class NotificationNormalService{
    
    @Autowired
    NotificationNormalRepository notificationNormalRepository;

    public List<NotificationNormal> getNotificationNormals(){
        try{
            return (List<NotificationNormal>) this.notificationNormalRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public NotificationNormal getNotificationNormal(Long id){
        try{
            return this.notificationNormalRepository.findById(id).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteNotificationNormal(Long id){
        try{
            this.notificationNormalRepository.delete(this.notificationNormalRepository.findById(id).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }

    public void createNotification(Notification notification){
        try{
            this.notificationNormalRepository.save((NotificationNormal)notification);
        }catch(PersistenceException exception){
            System.out.println(exception.getMessage());
        }
    }

    public boolean updateNotificationNormal(NotificationNormal notificationNormal){
        try{
            if(this.getNotificationNormal(notificationNormal.getIdNotification()) != null){
                this.notificationNormalRepository.save(notificationNormal);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar una notificación normal que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }

}
