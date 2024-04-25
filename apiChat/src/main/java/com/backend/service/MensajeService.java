package com.backend.service;

import com.backend.model.Mensaje;
import com.backend.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {
    @Autowired
    private MensajeRepository mensajeRepository;

    public Mensaje guardarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje).block();
    }
}
