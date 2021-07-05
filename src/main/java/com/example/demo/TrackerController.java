package com.example.demo;

import javax.validation.Valid;

import com.example.demo.dto.LinkDto;
import com.example.demo.repo.RepositorioImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@Controller
@RequestMapping("/link")
public class TrackerController {

    @Autowired
    private RepositorioImple repo;

    @PostMapping
    public ResponseEntity<?> postLink(@RequestBody @Valid LinkDto link){
        return new ResponseEntity<>(repo.save(link), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public RedirectView getLink(@PathVariable Integer linkId){

        String a = repo.readLinkById(linkId).getLink();
        return new RedirectView("http://"+a);

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkId){
        return new ResponseEntity<>(repo.readMetricsById(linkId), HttpStatus.ACCEPTED);
    }

}
