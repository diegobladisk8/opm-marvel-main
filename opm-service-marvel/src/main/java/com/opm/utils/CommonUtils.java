package com.opm.utils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.*;

public class CommonUtils {


    public static Response getMapping(String urlService, Map<String, String> bodyParameters, long timeout) throws IOException {

        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(timeout, TimeUnit.SECONDS)
                .writeTimeout(timeout, TimeUnit.SECONDS).readTimeout(timeout, TimeUnit.SECONDS).build();

        HttpUrl.Builder urlBuilder
                = requireNonNull(HttpUrl.parse(urlService)).newBuilder();

        if (bodyParameters != null) {
            for (String param : bodyParameters.keySet()) {
                urlBuilder.addQueryParameter(param, bodyParameters.get(param));
            }
        }

        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute();

    }


    public static String createMD5Hash(final String input)
            throws Exception {
        String hashText = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        hashText = convertToHex(messageDigest);
        return hashText;
    }


    private static String convertToHex(final byte[] messageDigest) {
        BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
            hexText = "0".concat(hexText);
        }
        return hexText;
    }
}
