package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.model.Piso;

@Repository
public interface PisoRepository extends CrudRepository<Piso, Long>{    
}
