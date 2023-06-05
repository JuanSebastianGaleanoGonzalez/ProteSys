package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.repository.NotificationGraveRepository;
import com.protesys.utils.notifications.Notification;
import com.protesys.utils.notifications.NotificationGrave;

@Service
public class NotificationGraveService{

    @Autowired
    NotificationGraveRepository notificationGraveRepository;

    public List<NotificationGrave> getNotificationGraves(){
        try{
            return (List<NotificationGrave>) this.notificationGraveRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public NotificationGrave getNotificationGrave(Long id){
        try{
            return this.notificationGraveRepository.findById(id).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteNotificationGrave(Long id){
        try{
            this.notificationGraveRepository.delete(this.notificationGraveRepository.findById(id).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }

    public void createNotification(Notification notification){
        try{
            this.notificationGraveRepository.save((NotificationGrave)notification);
        }catch(PersistenceException exception){
        }
    }

    public boolean updateNotificationGrave(NotificationGrave notificationGrave){
        try{
            if(this.getNotificationGrave(notificationGrave.getIdNotification()) != null){
                this.notificationGraveRepository.save(notificationGrave);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar una notificación grave que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }
}