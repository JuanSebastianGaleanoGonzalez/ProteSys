package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.utils.chat.Mensaje;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long>{
}
