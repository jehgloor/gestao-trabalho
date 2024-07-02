package com.gestao_trabalho.modules.comum.exception.model;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
