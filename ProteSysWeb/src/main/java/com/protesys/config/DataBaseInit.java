package com.protesys.config;

import java.util.Calendar;

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
import com.protesys.repository.ChatRepository;
import com.protesys.repository.CredencialRepository;
import com.protesys.repository.GrupoRepository;
import com.protesys.repository.PisoRepository;
import com.protesys.repository.UsuarioRepository;
import com.protesys.utils.chat.Chat;

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

    @Autowired
    ChatRepository chatRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
/*
        Usuario auxiliarUsuario = new Usuario(1007678869, "Juan Sebastian Galeano Gonzalez",
                "jusebastiangg@gmail.com", 7555555, Rol.ADMINISTRADOR.toString());
        Credencial auxiliarCredencial = new Credencial("elsebasgaleano", "123456789");
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.credencialRepository.save(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(1098765432, "Sofia Maria Torres Rodriguez", "sofiatorres@gmail.com", 1234567,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("sofiatorres", "sofiatorres");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(1234567890, "Manuel Alejandro Gomez Garcia", "manuelgomez@gmail.com", 2345678,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("manuelgomez", "manuelgomez");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(876543210, "Laura Sofia Hernandez Jimenez", "laurahernandez@gmail.com", 3456789,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("laurahernandez", "laurahernandez");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(456789012, "Carlos Andres Castro Suarez", "carloscastro@gmail.com", 4567890,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("carloscastro", "carloscastro");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(678901234, "Maria Fernanda Ortiz Diaz", "mariaortiz@gmail.com", 5678901,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("mariaortiz", "mariaortiz");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(890123456, "Andres Felipe Villa Mejia", "andresvilla@gmail.com", 6789012,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("andresvilla", "andresvilla");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(543210987, "Daniela Alejandra Osorio Vargas", "danielaosorio@gmail.com", 7890123,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("danielaosorio", "danielaosorio");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(432109876, "Jorge Eduardo Ramirez Cardenas", "jorgeramirez@gmail.com", 8901234,
                Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("jorgeramirez", "jorgeramirez");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        auxiliarUsuario = new Usuario(432109876, "Juan David Perez Lopez", "davidperez@gmail.com", 8901235,
        Rol.ADMINISTRADOR.toString());
        auxiliarCredencial = new Credencial("davidperez", "davidperez");
        this.credencialRepository.save(auxiliarCredencial);
        auxiliarUsuario.setCredencial(auxiliarCredencial);
        this.usuarioRepository.save(auxiliarUsuario);

        Calendar calendar = Calendar.getInstance();
        
        Grupo auxiliarGrupo = new Grupo("Mi grupo", calendar.getTime(), 0, "Normal");
       this.grupoRepository.save(auxiliarGrupo);
       
       auxiliarUsuario = this.usuarioRepository.findById((long) 1).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 2).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 3).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 4).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 5).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 6).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 7).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 8).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 9).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);
        auxiliarUsuario = this.usuarioRepository.findById((long) 10).get();
        auxiliarUsuario.setGrupo(auxiliarGrupo);
        this.usuarioRepository.save(auxiliarUsuario);

        Piso auxiliarPiso = new Piso("AAA111", 1);
        auxiliarPiso.setGrupo(this.grupoRepository.findById((long) 1).get());
        this.pisoRepository.save(auxiliarPiso);

        Casa auxiliarCasa = new Casa("Casa1", "La Candelaria", "Calle 9  # 3 - 15");
        this.casaRepository.save(auxiliarCasa);
        this.pisoRepository.findById((long)1).get().setCasa(auxiliarCasa);
 */    }

}
