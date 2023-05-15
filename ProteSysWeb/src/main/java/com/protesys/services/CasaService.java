package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.protesys.model.Casa;
import com.protesys.repository.CasaRepository;

@Service
public class CasaService {
    
    @Autowired
    CasaRepository casaRepository;

    public List<Casa> getCasas(){
        try{
            return (List<Casa>) this.casaRepository.findAll();
        }catch(PersistenceException exception){
            return null;
        }
    }

    public Casa getCasa(Long idCasa){
        try{
            return this.casaRepository.findById(idCasa).get();
        }catch(PersistenceException | NoSuchElementException exception){
            return null;
        }
    }

    public boolean deleteCasa(Long idCasa){
        try{
            this.casaRepository.delete(this.casaRepository.findById(idCasa).get());
            return true;
        }catch(PersistenceException | NoSuchElementException | DataIntegrityViolationException exception){
            return false;
        }
    }

    public boolean createCasa(Casa casa){
        try{
            this.casaRepository.save(casa);
            return true;
        }catch(PersistenceException exception){
            return false;
        }
    }

    public boolean updateCasa(Casa casa){
        try{
            if(this.getCasa(casa.getIdCasa()) != null){
                this.casaRepository.save(casa);
                return true;
            }else{
                throw new NoSuchElementException("No se puede actualizar una casa que no existe.");
            }
        }catch(PersistenceException | NoSuchElementException exception){
            return false;
        }
    }
}
