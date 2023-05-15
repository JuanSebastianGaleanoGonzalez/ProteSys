package com.protesys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protesys.model.Usuario;
import com.protesys.repository.UsuarioRepository;

@Service
public class SensorService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios(){
        return (List<Usuario>) usuarioRepository.findAll();
    }
}
