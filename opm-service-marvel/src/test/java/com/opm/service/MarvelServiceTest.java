package com.opm.service;

import okhttp3.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MarvelServiceTest {


    @Test
    public void whenSendGetRequest_assertEquals() throws Exception {
        ApiMarvelHttp apiRestMarvelHttp = new ApiMarvelHttp();
        Response response = apiRestMarvelHttp.getCharacters("https://gateway.marvel.com:443",
                "/v1/public/characters", "3d2ecf520601a9dc920d9e7ca30e0e65", "", null);
        assertEquals(response.code(), 200);
    }

    @Test
    public void whenSendGetRequest_assertNotEquals() throws Exception {
        ApiMarvelHttp apiRestMarvelHttp = new ApiMarvelHttp();
        Response response = apiRestMarvelHttp.getCharacters("https://gateway.marvel.com:443",
                "/v1/public/characters", "3d2ecf520601a9dc920d9e7ca30e0e65", "e158d655be964774afae610658d53c467738746f", null);
        assertNotEquals(response.code(), 200);
    }

}
