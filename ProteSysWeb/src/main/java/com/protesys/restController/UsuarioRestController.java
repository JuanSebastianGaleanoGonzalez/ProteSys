package com.protesys.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protesys.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRestController {

    @Autowired
    UsuarioService usuarioService;

     
}
