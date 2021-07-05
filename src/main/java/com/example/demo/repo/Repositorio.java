package com.example.demo.repo;

import com.example.demo.dto.LinkDto;
import com.example.demo.exception.InvalidationLink;
import com.example.demo.exception.LinkNotFound;
import com.example.demo.exception.SenhaIncorreta;
import com.fasterxml.jackson.databind.util.LinkedNode;

public interface Repositorio {

    public <T> T readAll();
    public <T> T readLinkById(Integer id, String senha) throws LinkNotFound, InvalidationLink, SenhaIncorreta ;
    public <T> T readMetricsById(Integer id, String senha) throws LinkNotFound, SenhaIncorreta ;
    public <T> T save(LinkDto link);
    public void delete(Integer id, String senha) throws LinkNotFound, SenhaIncorreta ;
    public <T> T invalidateLinkById(Integer id, String senha) throws LinkNotFound, SenhaIncorreta ;
    public <T> T validateLinkById(Integer id, String senha) throws LinkNotFound, SenhaIncorreta;

}
