package com.backend.controller;

import com.backend.model.Mensaje;
import com.backend.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {
    @Autowired
    private MensajeService mensajeService;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public Mensaje sendMessage(Mensaje mensaje) {
        mensaje.setFechaEnvio(LocalDateTime.now());
        System.out.println("Nombre: " + mensaje.getNombre());
        System.out.println("Mensaje recibido: " + mensaje.getContenido());
        System.out.println("Hora: " + mensaje.getFechaEnvio());
        return mensajeService.guardarMensaje(mensaje);
    }
}