package com.protesys.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.protesys.model.Piso;
import com.protesys.repository.PisoRepository;

@Service
public class PisoService {

    @Autowired
    PisoRepository pisoRepository;

    public List<Piso> getPisos() {
        try {
            return (List<Piso>) this.pisoRepository.findAll();
        } catch (PersistenceException exception) {
            return null;
        }
    }

    public Piso getPiso(Long idPiso) {
        try {
            return this.pisoRepository.findById(idPiso).get();
        } catch (PersistenceException | NoSuchElementException exception) {
            return null;
        }
    }

    public boolean deletePiso(Long idPiso) {
        try {
            this.pisoRepository.delete(this.pisoRepository.findById(idPiso).get());
            return true;
        } catch (PersistenceException | NoSuchElementException | DataIntegrityViolationException exception) {
            return false;
        }
    }

    public boolean createPiso(Piso piso) {
        try {
            this.pisoRepository.save(piso);
            return true;
        } catch (PersistenceException exception) {
            return false;
        }
    }

    public boolean updatePiso(Piso piso) {
        try {
            if (this.getPiso(piso.getIdPiso()) != null) {
                this.pisoRepository.save(piso);
                return true;
            } else {
                throw new NoSuchElementException("No se puede actualizar un piso que no existe.");
            }
        } catch (PersistenceException | NoSuchElementException exception) {
            return false;
        }
    }
}
