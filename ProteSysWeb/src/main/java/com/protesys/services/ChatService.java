package com.protesys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.protesys.repository.ChatRepository;

@Service
public class ChatService {
    
    @Autowired
    ChatRepository chatRepository;
    
}
