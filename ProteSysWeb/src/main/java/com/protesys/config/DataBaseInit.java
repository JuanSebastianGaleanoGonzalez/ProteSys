package com.protesys.config;

import java.time.LocalTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.protesys.model.Casa;
import com.protesys.model.Credencial;
import com.protesys.model.Grupo;
import com.protesys.model.Piso;
import com.protesys.model.Rol;
import com.protesys.model.Usuario;
import com.protesys.repository.CasaRepository;
import com.protesys.repository.CredencialRepository;
import com.protesys.repository.GrupoRepository;
import com.protesys.repository.PisoRepository;
import com.protesys.repository.UsuarioRepository;

@Component
public class DataBaseInit implements ApplicationRunner {

    @Autowired
    CredencialRepository credencialRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    PisoRepository pisoRepository;

    @Autowired
    CasaRepository casaRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        Usuario auxiliarUsuario = new Usuario(1007678869, "Juan Sebastian Galeano Gonzalez",
                "jsebastian-galeano@javeriana.edu.co", 123456789, Rol.ADMINISTRADOR.toString());
        Credencial auxiliarCredencial = new Credencial("elsebasgaleano", "123456");
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.credencialRepository.save(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(1098765432, "Sofía González Pérez", "sgonzalezperez@gmail.com", 1234567,
                Rol.NORMAL.toString());
        auxiliarCredencial = new Credencial("sgonzalezperez", "123456");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(1234567890, "Daniel Ramírez Gómez", "dramirezgomez@gmail.com", 2345678,
                Rol.INVITADO.toString());
        auxiliarCredencial = new Credencial("dramirezgomez", "234567");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(876543210, "Valeria Torres Sánchez", "vtorressanchez@gmail.com", 3456789,
                Rol.ADMIN_GRUPO.toString());
        auxiliarCredencial = new Credencial("vtorressanchez", "345678");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(456789012, "Juan Carlos Hernández Ortiz", "jchernandezortiz@gmail.com", 4567890,
                Rol.NORMAL.toString());
        auxiliarCredencial = new Credencial("jchernandezortiz", "456789");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(678901234, "Paola García López", "pgarcialopez@gmail.com", 5678901,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("pgarcialopez", "567890");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(890123456, "Jorge Martínez Jiménez", "jmartinezjimenez@gmail.com", 6789012,
                Rol.INVITADO.toString());
        auxiliarCredencial = new Credencial("jmartinezjimenez", "678901");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(543210987, "Ana Torres Ramírez", "atorresramirez@gmail.com", 7890123,
                Rol.ADMIN_GRUPO.toString());
        auxiliarCredencial = new Credencial("atorresramirez", "789012");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(432109876, "Luisa Fernández Gutiérrez", "lfernandezgutierrez@gmail.com", 8901234,
                Rol.NORMAL.toString());
        auxiliarCredencial = new Credencial("lfernandezgutierrez", "890123");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(321098765, "Carlos Rodríguez Pérez", "crodriguezperez@gmail.com", 9012345,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("crodriguezperez", "901234");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(654321098, "María García Rodríguez", "mgarciarodriguez@gmail.com", 1123456,
                Rol.INVITADO.toString());
        auxiliarCredencial = new Credencial("mgarciarodriguez", "112345");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        Grupo auxiliarGrupo = new Grupo("Primero", null, 0);
        this.grupoRepository.save(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 1).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 2).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 3).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);


        auxiliarGrupo = new Grupo("Segundo", null, 0);
        this.grupoRepository.save(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 4).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 5).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 6).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarGrupo = new Grupo("Tercero", null, 0);
        this.grupoRepository.save(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 7).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 8).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        auxiliarUsuario = this.usuarioRepository.findById((long) 9).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);

        Piso auxiliarPiso = new Piso("AAA111", 1);
        auxiliarPiso.setGrupo(this.grupoRepository.findById((long) 1).get());
        this.pisoRepository.save(auxiliarPiso);

        auxiliarPiso = new Piso("BBB222", 2);
        auxiliarPiso.setGrupo(this.grupoRepository.findById((long) 2).get());
        this.pisoRepository.save(auxiliarPiso);


        auxiliarPiso = new Piso("CCC333", 3);
        auxiliarPiso.setGrupo(this.grupoRepository.findById((long) 3).get());
        this.pisoRepository.save(auxiliarPiso);

        Casa auxiliarCasa = new Casa("Casa1", "La Candelaria", "Calle 9  # 3 - 15");
        this.casaRepository.save(auxiliarCasa);
        this.pisoRepository.findById((long)1).get().setCasa(auxiliarCasa);
        this.pisoRepository.findById((long)2).get().setCasa(auxiliarCasa);
        this.pisoRepository.findById((long)3).get().setCasa(auxiliarCasa);
    }

}
