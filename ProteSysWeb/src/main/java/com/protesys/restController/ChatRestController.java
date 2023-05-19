package com.protesys.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protesys.services.ChatService;
import com.protesys.utils.chat.Chat;

@RestController
@RequestMapping(value = "/chat")
public class ChatRestController {

    @Autowired
    ChatService chatService;

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search")
    public List<Chat> listarChats() {
        return this.chatService.getChats();
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @GetMapping(value = "/search/{id}")
    public Chat buscarChat(@PathVariable("id") Long id) {
        return this.chatService.getChat(id);
    }

    @Secured({"ROLE_ADMINISTRADOR"})
    @DeleteMapping(value = "/delete/{id}")
    public boolean eliminarChat(@PathVariable("id") Long id) {
        return this.chatService.deleteChat(id);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PostMapping(value = "/create")
    public boolean crearChat(@RequestBody Chat chat) {
        return this.chatService.createChat(chat);
    }

    @Secured({"ROLE_NORMAL", "ROLE_INVITADO", "ROLE_ADMINISTRADOR", "ROLE_ADMIN_GRUPO"})
    @PutMapping(value = "/update")
    public boolean actualizarChat(@RequestBody Chat chat) {
        return this.chatService.updateChat(chat);
    }
}
