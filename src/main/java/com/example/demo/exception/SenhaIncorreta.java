package com.example.demo.exception;

public class SenhaIncorreta extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public SenhaIncorreta(String mensagem) {
        super(mensagem);
    }
    public SenhaIncorreta(Exception e) {
        super(e);
    }

}
