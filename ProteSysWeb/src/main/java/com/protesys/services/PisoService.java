package com.protesys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protesys.repository.PisoRepository;

@Service
public class PisoService {
    
    @Autowired
    PisoRepository pisoRepository;
    
}
