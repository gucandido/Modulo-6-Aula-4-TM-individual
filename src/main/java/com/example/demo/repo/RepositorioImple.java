package com.example.demo.repo;

import com.example.demo.dto.LinkDto;
import com.example.demo.dto.MetricsDto;
import com.example.demo.exception.LinkNotFound;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.DemoApplication.staticDb;
import static com.example.demo.DemoApplication.staticMetrics;

@Repository
public class RepositorioImple implements Repositorio{

    public RepositorioImple() {
    }

    @Override
    public List<LinkDto> readAll() {

        List<LinkDto> ls = new ArrayList<>();
        staticDb.entrySet().forEach(x->ls.add(x.getValue()));

        return ls;
    }

    @Override
    public LinkDto readLinkById(Integer id) throws LinkNotFound {

        LinkDto l = staticDb.get(id);
        if(l != null) {
            MetricsDto m = staticMetrics.get(id);

            if (m == null)
                staticMetrics.put(id, new MetricsDto(0));

            staticMetrics.get(id).addVisita();

            return staticDb.get(id);
        }else{
            throw new LinkNotFound("Link não cadastrado no sistema!");
        }


    }

    @Override
    public LinkDto save(LinkDto link) {
        if(staticDb.isEmpty())
            staticDb.put(0,link);
        else
            staticDb.put(staticDb.keySet().stream().max(Integer::compare).get()+1,link);

        return link;
    }

    @Override
    public MetricsDto readMetricsById(Integer id) throws LinkNotFound {

        if(staticMetrics.get(id) == null)
            throw new LinkNotFound("Link não cadastrado no sistema, portanto não há métricas de acesso!");
        else
            return staticMetrics.get(id);
    }

    @Override
    public void delete(Integer id) {

        staticDb.remove(id);

    }

}
