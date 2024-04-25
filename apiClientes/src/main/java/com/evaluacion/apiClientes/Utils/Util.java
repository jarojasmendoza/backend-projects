package com.evaluacion.apiClientes.Utils;

import com.evaluacion.apiClientes.exception.ClienteException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static com.evaluacion.apiClientes.Utils.Constantes.REGLA_CLAVE;
import static com.evaluacion.apiClientes.Utils.Constantes.REGLA_CORREO;


public class Util {

    public static void validarCorreo(String correo){
        //String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(REGLA_CORREO);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            System.out.println("El formato del correo no es correcto.");
            throw new ClienteException("El formato del correo no es correcto.");
        }
    }
    public static void validarClave(String clave) {

        //String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()-_+=])[a-zA-Z0-9!@#$%^&*()-_+=]{8,}$";
        Pattern pattern = Pattern.compile(REGLA_CLAVE);
        Matcher matcher = pattern.matcher(clave);

        if (!matcher.matches()) {
            System.out.println("La contraseña cumple con los requisitos.");
            throw new ClienteException("La contraseña cumple con los requisitos.");
        }
    }

}
