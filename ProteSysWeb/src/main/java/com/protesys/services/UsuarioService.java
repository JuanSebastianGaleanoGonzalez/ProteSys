package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.model.Usuario;
import com.protesys.model.UsuarioSubscriberImplementation;
import com.protesys.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioSubscriberImplementation usuarioSubscriberImplementation;

    public List<Usuario> getUsuarios() {
        try {
            return (List<Usuario>) this.usuarioRepository.findAll();
        } catch (PersistenceException exception) {
            return null;
        }
    }

    public Usuario getUsuario(Long idUsuario) {
        try {
            return this.usuarioRepository.findById(idUsuario).get();
        } catch (PersistenceException | NoSuchElementException exception) {
            return null;
        }
    }

    public boolean deleteUsuario(Long idUsuario) {
        try {
            this.usuarioRepository.delete(this.usuarioRepository.findById(idUsuario).get());
            return true;
        } catch (PersistenceException | NoSuchElementException | DataIntegrityViolationException exception) {
            return false;
        }
    }

    public boolean createUsuario(Usuario usuario) {
        try {
            this.usuarioRepository.save(usuario);
            return true;
        } catch (PersistenceException exception) {
            return false;
        }
    }

    public boolean updateUsuario(Usuario usuario) {
        try {
            if (this.getUsuario(usuario.getIdUsuario()) != null) {
                this.usuarioRepository.save(usuario);
                return true;
            } else {
                throw new NoSuchElementException("No se puede actualizar un usuario que no existe.");
            }
        } catch (PersistenceException | NoSuchElementException exception) {
            return false;
        }
    }

    public void activarBotonPanico(){
        usuarioSubscriberImplementation.activarBotonPanico();
    }
}
