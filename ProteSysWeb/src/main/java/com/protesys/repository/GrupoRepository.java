package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.model.Grupo;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Long>{ 
}
