package com.wolox.jsontest.exception;

public class JsonTestException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String PERMISO_EXISTE = "El permiso ha registrar ya existe";
    public static final String PERMISO_NO_EXISTE = "El permiso ha modificar no existe"; 
    public static final String USUARIO_NO_VALIDO = "No se puede registrar el mismo usuario del album";  
    public static final String USUARIO_NO_EXISTE = "El usuario no existe";  
    public static final String ALBUM_NO_EXISTE = "El Album no existe";

    public JsonTestException(String message) {
        super(message);
    }
}