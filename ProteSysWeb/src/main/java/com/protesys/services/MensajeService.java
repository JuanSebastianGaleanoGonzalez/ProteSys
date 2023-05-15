package com.protesys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protesys.repository.MensajeRepository;

@Service
public class MensajeService {
    
    @Autowired
    MensajeRepository mensajeRepository;
    
}
