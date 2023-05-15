package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.model.Credencial;

@Repository
public interface CredencialRepository extends CrudRepository<Credencial, Long> {
}
