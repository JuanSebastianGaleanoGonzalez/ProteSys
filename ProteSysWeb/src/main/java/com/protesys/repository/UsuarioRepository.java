package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
