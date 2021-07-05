package com.example.demo;

import javax.validation.Valid;

import com.example.demo.dto.LinkDto;
import com.example.demo.repo.RepositorioImple;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
    public RedirectView getLink(@PathVariable Integer linkId, @RequestBody ObjectNode json){

        String senhaLink = json.get("senha").asText();

        String a = repo.readLinkById(linkId, senhaLink).getLink();
        return new RedirectView("http://"+a);

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkId, @RequestBody ObjectNode json){

        String senhaLink = json.get("senha").asText();

        return new ResponseEntity<>(repo.readMetricsById(linkId,senhaLink), HttpStatus.ACCEPTED);
    }

    @PostMapping("/inativar")
    public ResponseEntity<?> postInativar(@RequestBody ObjectNode json){

        Integer idLink = json.get("idLink").asInt();
        String senhaLink = json.get("senha").asText();

        return new ResponseEntity<>(repo.invalidateLinkById(idLink,senhaLink), HttpStatus.ACCEPTED);
    }

    @PostMapping("/ativar")
    public ResponseEntity<?> postAtivar(@RequestBody ObjectNode json){

        Integer idLink = json.get("idLink").asInt();
        String senhaLink = json.get("senha").asText();

        return new ResponseEntity<>(repo.validateLinkById(idLink, senhaLink), HttpStatus.ACCEPTED);
    }

}
