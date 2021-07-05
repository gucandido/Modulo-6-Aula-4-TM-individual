package com.example.demo.exception;

public class LinkNotFound extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public LinkNotFound(String mensagem) {
        super(mensagem);
    }
    public LinkNotFound(Exception e) {
        super(e);
    }

}
