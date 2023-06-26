package com.opm.controller;

import com.opm.model.Audit;
import com.opm.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api/audit", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping
//    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    public ResponseEntity<List<Audit>> findAll() {
        return new ResponseEntity<>(auditService.findAll(), HttpStatus.OK);
    }
}





