package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.control.NotificationController;
import com.protesys.repository.ChatRepository;
import com.protesys.repository.MensajeRepository;
import com.protesys.utils.chat.Chat;
import com.protesys.utils.chat.Mensaje;

@Service
public class ChatService {
    
    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MensajeRepository mensajeRepository;

    @Autowired
    NotificationController notificationController;

    public List<Chat> getChats(){
        try{
            return (List<Chat>) this.chatRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public Chat getChat(Long idChat){
        try{
            return this.chatRepository.findById(idChat).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteChat(Long idChat){
        try{
            this.chatRepository.delete(this.chatRepository.findById(idChat).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }

    public boolean createChat(Chat chat){
        try{
            this.chatRepository.save(chat);
            this.notificationController.notificacionCreacionChat(chat);
            return true;
        }catch(PersistenceException exception){
            return false;
        }
    }

    public Chat updateChat(Chat chat){
        List<Mensaje> antes = this.chatRepository.findById(chat.getIdChat()).get().getMensajes();
        List<Mensaje> despues = chat.getMensajes();
        try{
            if(this.getChat(chat.getIdChat()) != null){
                this.chatRepository.save(chat);
                for(Mensaje mensaje: chat.getMensajes()){
                    mensaje.setChat(chat);
                    this.mensajeRepository.save(mensaje);
                }
                for(Mensaje mensaje: despues){
                    if(!antes.contains(despues)){
                        this.notificationController.notificacionMensajeRecibido(mensaje, this.getChats());
                    }
                }
                return chat;
            }else{
                throw new NoSuchElementException("No se puede actualizar un chat que no existe.");
            }           
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }
}
