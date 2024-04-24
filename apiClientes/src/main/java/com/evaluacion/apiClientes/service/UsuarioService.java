package com.evaluacion.apiClientes.service;

import com.evaluacion.apiClientes.Utils.Util;
import com.evaluacion.apiClientes.exception.ClienteException;
import com.evaluacion.apiClientes.model.Usuario;
import com.evaluacion.apiClientes.model.UsuarioResponse;
import com.evaluacion.apiClientes.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public UsuarioResponse crearUsuario(Usuario usuario) {

        //Validaciones
        Util.validarCorreo(usuario.getEmail());
        Util.validarClave(usuario.getPassword());
        Usuario usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            throw new ClienteException("El correo ya está registrado");
        }

        usuario.setCreated(LocalDateTime.now());
        usuario.setModified(LocalDateTime.now());
        usuario.setLastLogin(LocalDateTime.now());
        usuario.setToken(generarTokenJWT());
        usuario.setActive(true);

        Usuario usuarioBd = usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setId(usuarioBd.getId());
        usuarioResponse.setCreated(usuarioBd.getCreated());
        usuarioResponse.setModified(usuarioBd.getModified());
        usuarioResponse.setLastLogin(usuarioBd.getLastLogin());
        usuarioResponse.setToken(usuarioBd.getToken());
        usuarioResponse.setActive(usuarioBd.getActive());

        return usuarioResponse;
    }

    public String generarTokenJWT() {
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        long tiempoExpiracion = 86400000;

        String usuarioId = UUID.randomUUID().toString();

        return Jwts.builder()
                .setSubject(usuarioId) // Utiliza el UUID como subject
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tiempoExpiracion))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
