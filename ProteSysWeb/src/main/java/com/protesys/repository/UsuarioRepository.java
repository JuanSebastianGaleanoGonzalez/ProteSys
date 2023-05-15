package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import com.protesys.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {
}
