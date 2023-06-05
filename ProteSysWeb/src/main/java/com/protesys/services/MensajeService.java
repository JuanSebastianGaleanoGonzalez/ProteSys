package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.repository.ChatRepository;
import com.protesys.repository.MensajeRepository;
import com.protesys.utils.chat.Mensaje;

@Service
public class MensajeService {

    @Autowired
    MensajeRepository mensajeRepository;

    @Autowired
    ChatRepository chatRepository;

    public List<Mensaje> getMensajes() {
        try {
            return (List<Mensaje>) this.mensajeRepository.findAll();
        } catch (PersistenceException exception) {
            return null;
        }
    }

    public Mensaje getMensaje(Long idMensaje) {
        try {
            return this.mensajeRepository.findById(idMensaje).get();
        } catch (PersistenceException | NoSuchElementException exception) {
            return null;
        }
    }

    public boolean deleteMensaje(Long idMensaje) {
        try {
            this.mensajeRepository.delete(this.mensajeRepository.findById(idMensaje).get());
            return true;
        } catch (PersistenceException | NoSuchElementException | DataIntegrityViolationException exception) {
            return false;
        }
    }

    public Mensaje createMensaje(Mensaje mensaje) {
        try {
            this.mensajeRepository.save(mensaje);
            return mensaje;
        } catch (PersistenceException exception) {
            return null;
        }
    }

    public boolean updateMensaje(Mensaje mensaje) {
        try {
            if (this.getMensaje(mensaje.getIdMensaje()) != null) {
                this.mensajeRepository.save(mensaje);
                return true;
            } else {
                throw new NoSuchElementException("No se puede actualizar un mensaje que no existe.");
            }
        } catch (PersistenceException | NoSuchElementException exception) {
            return false;
        }
    }
}
