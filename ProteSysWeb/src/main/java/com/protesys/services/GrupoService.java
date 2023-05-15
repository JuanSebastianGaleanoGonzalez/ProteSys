package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.model.Grupo;
import com.protesys.repository.GrupoRepository;

@Service
public class GrupoService {
    
    @Autowired
    GrupoRepository grupoRepository;

    public List<Grupo> getGrupos(){
        try{
            return (List<Grupo>) this.grupoRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }
    
    public Grupo getGrupo(Long idGrupo){
        try{
            return this.grupoRepository.findById(idGrupo).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }
    
    public boolean deleteGrupo(Long idGrupo){
        try{
            this.grupoRepository.delete(this.grupoRepository.findById(idGrupo).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }
    
    public boolean createGrupo(Grupo grupo){
        try{
            this.grupoRepository.save(grupo);
            return true;
        }catch(PersistenceException exception){
            return false;
        }
    }
    
    public boolean updateGrupo(Grupo grupo){
        try{
            if(this.getGrupo(grupo.getIdGrupo()) != null){
                this.grupoRepository.save(grupo);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar un grupo que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }
}
