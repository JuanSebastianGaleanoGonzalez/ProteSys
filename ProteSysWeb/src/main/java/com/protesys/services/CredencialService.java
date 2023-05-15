package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.model.Credencial;
import com.protesys.repository.CredencialRepository;

@Service
public class CredencialService {
    
    @Autowired
    CredencialRepository credencialRepository;

    public List<Credencial> getCredenciales(){
        try{
            return (List<Credencial>) this.credencialRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public Credencial getCredencial(Long idCredencial){
        try{
            return this.credencialRepository.findById(idCredencial).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteCredencial(Long idCredencial){
        try{
            this.credencialRepository.delete(this.credencialRepository.findById(idCredencial).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }

    public boolean createCredencial(Credencial credencial){
        try{
            this.credencialRepository.save(credencial);
            return true;
        }catch(PersistenceException exception){
            return false;
        }
    }

    public boolean updateCredencial(Credencial credencial){
        try{
            if(this.getCredencial(credencial.getIdCredencial()) != null){
                this.credencialRepository.save(credencial);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar una credencial que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }
}
