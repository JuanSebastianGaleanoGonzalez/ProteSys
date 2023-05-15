package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.model.Casa;

@Repository
public interface CasaRepository extends CrudRepository<Casa, Long> {
}
