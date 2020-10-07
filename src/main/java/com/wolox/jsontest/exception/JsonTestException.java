package com.wolox.jsontest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
    
    public ResponseStatusException getExceptionController() {
    	if(this.getMessage().equals(PERMISO_NO_EXISTE) || this.getMessage().equals(ALBUM_NO_EXISTE) || 
    			this.getMessage().equals(USUARIO_NO_EXISTE)) {
    		return new ResponseStatusException(
			          HttpStatus.NOT_FOUND, this.getMessage());
    	}else if(this.getMessage().equals(PERMISO_EXISTE)) {
    		return new ResponseStatusException(
			          HttpStatus.CONFLICT, this.getMessage());
    	}else {
    		return new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, this.getMessage());
    	}    		
    }
}