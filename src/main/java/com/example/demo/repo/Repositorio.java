package com.example.demo.repo;

import com.example.demo.dto.LinkDto;
import com.example.demo.exception.LinkNotFound;
import com.fasterxml.jackson.databind.util.LinkedNode;

public interface Repositorio {

    public <T> T readAll();
    public <T> T readLinkById(Integer id) throws LinkNotFound;
    public <T> T readMetricsById(Integer id) throws LinkNotFound;
    public <T> T save(LinkDto link);
    public void delete(Integer id);


}
