package com.example.demo.exception;

public class InvalidationLink extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidationLink(String mensagem) {
        super(mensagem);
    }
    public InvalidationLink(Exception e) {
        super(e);
    }


}
