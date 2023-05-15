package com.protesys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protesys.repository.GrupoRepository;

@Service
public class GrupoService {
    
    @Autowired
    GrupoRepository grupoRepository;
    
}
