package com.opm.service;

import com.opm.model.Audit;
import com.opm.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {


    @Autowired
    AuditRepository auditRepository;

    public List<Audit> findAll() {
        return auditRepository.findAll();
    }

}
