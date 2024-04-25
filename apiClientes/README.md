# API REST de Gestión de Usuarios

Esta API REST proporciona endpoints para la gestión de usuarios, incluyendo la creación, consulta y modificación de usuarios.

## Requisitos previos

- Java JDK 8 o superior
- Gradle 8.0 o superior
- IDE de desarrollo compatible con Java (por ejemplo, IntelliJ IDEA, Eclipse)
- Postman u otra herramienta similar para probar las solicitudes HTTP

## Ejecución del proyecto

1. Clona el repositorio desde GitHub: 
git clone https://github.com/jarojasmendoza/apiClientes.git
2. Abre el proyecto en tu IDE de desarrollo.
3. Ejecuta la aplicación desde tu IDE o utilizando Gradle:
4. La API estará disponible en `http://localhost:8080`.
## Endpoints disponibles

### Crear usuario

- **URL:** `POST /api/usuarios/crear`
- **Descripción:** Crea un nuevo usuario con los datos proporcionados.
- **Cuerpo de la solicitud:**
```json
{
 "name": "Juan Rodriguez",
 "email": "juan@rodriguez.org",
 "password": "hunter2J@1as",
 "phones": [
   {
     "number": "123456789",
     "citycode": "1",
     "contrycode": "57"
   }
 ]
}
```
#### Postman:
1. Utilizar la siguiente url: `http://localhost:8080/api/usuarios/crear`
2. Insertar el json de prueba. 
3. Enviar la petición de tipo post.
#### Respuesta exitosa:

Código de estado: 201 (Created)
Cuerpo de la respuesta: Usuario creado con éxito, incluyendo ID, fecha de creación, fecha de modificación, último inicio de sesión, token y estado de activación.
```json
{
    "id": "e9db75e4-8520-47c9-afb7-d2360119540f",
    "created": "2024-04-08T12:56:14.4816725",
    "modified": "2024-04-08T12:56:14.4816725",
    "lastLogin": "2024-04-08T12:56:14.4816725",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI5ZWNlZDRhZi1hZDQ4LTQ4MzctODk2NC05NmI0MmEzODA4ZTkiLCJpYXQiOjE3MTI1OTg5NzQsImV4cCI6MTcxMjY4NTM3NH0.muJduBSs7xi3KhciWhKmOpYPkL2Xlygz-Nu1gsylgiqP7A2CzHc5n4XIr4Brf3dGrBJzebgBVoq-QR7wjTziMw",
    "active": true
}
```

#### Errores posibles:

Código de estado: 400 (Bad Request)
Cuerpo de la respuesta: Mensaje de error indicando el problema encontrado.

```json
{
    "mensaje": "El formato del correo no es correcto."
}
```

```json
{
    "mensaje": "La contraseña cumple con los requisitos."
}
```

```json
{
    "mensaje": "El correo ya está registrado"
}
```

## Constantes
En el archivo `application.properties` se encuentran las siguientes constantes utilizadas para validar el correo y la clave de los usuarios:

- **Correo electrónico (`api.usuario.regla.correo`):**
  Esta constante define una expresión regular que describe el patrón que deben seguir las direcciones de correo electrónico válidas. La expresión regular `^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$` garantiza que las direcciones de correo electrónico cumplan con estándares básicos, como tener un formato correcto de aaaaaaa@dominio.cl.

  
- **Clave de usuario (`api.usuario.regla.clave`):**
  Esta constante define una expresión regular que describe el patrón que deben seguir las contraseñas de los usuarios. La expresión regular `^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$` especifica que las contraseñas deben cumplir con los siguientes criterios:
    - Al menos un dígito (`0-9`).
    - Al menos una letra minúscula (`a-z`).
    - Al menos una letra mayúscula (`A-Z`).
    - Al menos un carácter especial (`@#$%^&+=`).
    - No espacios en blanco.
    - Una longitud mínima de 8 caracteres.