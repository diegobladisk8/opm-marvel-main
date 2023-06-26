package com.opm.service;

import com.opm.utils.CommonUtils;
import com.opm.utils.ConstantsUtils;
import okhttp3.Response;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiMarvelHttp {

    public Response getCharacters(String apiBaseUrl, String apiBaseUrlPathV1, String apiPublicKey, String apiPrivateKey, String characterId) throws Exception {

        String urlService = apiBaseUrl.concat(apiBaseUrlPathV1);

        if (characterId != null && characterId.length() > 0) {
            urlService = urlService.concat("/" + characterId);
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put(ConstantsUtils.API_KEY, apiPublicKey);

        String tsParam = String.valueOf(new Date().getTime());
        params.put(ConstantsUtils.API_TS, tsParam);

        String hashParam = tsParam.concat(apiPrivateKey.concat(apiPublicKey));
        params.put(ConstantsUtils.API_HASH, CommonUtils.createMD5Hash(hashParam));

        return CommonUtils.getMapping(urlService, params, 30L);
    }

}
