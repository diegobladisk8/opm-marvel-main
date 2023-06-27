package com.opm.service;

import com.opm.MarvelApiRestApplicationTests;
import com.opm.model.Audit;
import com.opm.repository.AuditRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = MarvelApiRestApplicationTests.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Import(AuditRepository.class)
public class AuditServiceTest {

    @MockBean
    private AuditRepository repo;

    @Before
    public void setup() {
        repo = mock(AuditRepository.class);
    }

    @Test
    @Order(1)
    public void findAllTest() throws Exception {

        Audit audit = new Audit();
        audit.setId(1L);
        audit.setPath("/marvel");
        audit.setFecha(LocalDate.now());
        audit.setHora(LocalTime.now());

        Audit audit2 = new Audit();
        audit2.setId(1L);
        audit2.setPath("/marvel/1233445");
        audit2.setFecha(LocalDate.now());
        audit2.setHora(LocalTime.now());

        List<Audit> list = new ArrayList<>();
        list.add(audit);
        list.add(audit2);

        when(repo.findAll()).thenReturn(list);

        assertEquals(list.size(), repo.findAll().size());
    }

}


