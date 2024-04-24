package com.evaluacion.apiClientes.controller;

import com.evaluacion.apiClientes.model.ErrorResponse;
import com.evaluacion.apiClientes.model.Usuario;
import com.evaluacion.apiClientes.model.UsuarioResponse;
import com.evaluacion.apiClientes.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
@Api(tags = "API", description = "Endpoints para gestionar Usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    @ApiOperation(value = "Crear Usuario",
    response = UsuarioResponse.class)
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {

        try {
            UsuarioResponse nuevoUsuario = usuarioService.crearUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(exception.getMessage()));
        }

    }
}
