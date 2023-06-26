package com.opm.controller;

import com.opm.service.MarvelService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping(value = "/api/marvel", produces = MediaType.APPLICATION_JSON_VALUE)
public class MarvelController {

    @Autowired
    private MarvelService marvelService;


    @GetMapping
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> findAll() throws Exception {
        Response response = marvelService.getCharacters(null);
        return new ResponseEntity<>(response.body() != null ? Objects.requireNonNull(response.body()).string() : null, HttpStatus.OK);
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<String> findByCharacterId(@PathVariable("characterId") String characterId) throws Exception {
        Response response = marvelService.getCharacters(characterId);
        return new ResponseEntity<>(response.body() != null ? Objects.requireNonNull(response.body()).string() : null, HttpStatus.OK);
    }
}
