package com.opm.service;

import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MarvelService {

    @Value("${api.base.url}")
    private String apiBaseUrl;
    @Value("${api.base.url.path.v1}")
    private String apiBaseUrlPathV1;
    @Value("${api.public.key}")
    private String apiPublicKey;
    @Value("${api.private.key}")
    private String apiPrivateKey;

    public Response getCharacters(String characterId) throws Exception {
        ApiMarvelHttp apiService = new ApiMarvelHttp();
        return apiService.getCharacters(apiBaseUrl, apiBaseUrlPathV1, apiPublicKey, apiPrivateKey, characterId);

    }

}
