package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LinkDto {

    @NotEmpty
    private String link;

    @NotEmpty
    private String senha;

    @NotNull
    private boolean valido = true;

    public LinkDto() {
    }

    public LinkDto(@NotEmpty String link, String senha) {
        this.link = link;
        this.senha = senha;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean validarSenha(String senha){
        return this.senha.equals(senha);
    }
}
