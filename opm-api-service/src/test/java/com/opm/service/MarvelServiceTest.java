package com.opm.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.mockito.Mockito;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarvelServiceTest {

    @Autowired
    MarvelService marvelService;

    @Test
    @Order(1)
    public void whenSendGetRequest_assertEquals() throws Exception {
        Mockito.when(marvelService.getCharacters(null));
    }
}
