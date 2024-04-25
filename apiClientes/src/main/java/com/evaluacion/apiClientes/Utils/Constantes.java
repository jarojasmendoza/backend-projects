package com.evaluacion.apiClientes.Utils;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constantes {
    public static String REGLA_CORREO;
    @Value("${api.usuario.regla.correo}")
    private String reglaCorreoValue;

    public static  String REGLA_CLAVE;
    @Value("${api.usuario.regla.clave}")
    private String reglaClaveValue;
    @PostConstruct
    public void init() {
        REGLA_CORREO = reglaCorreoValue;
        REGLA_CLAVE = reglaClaveValue;
    }

}
