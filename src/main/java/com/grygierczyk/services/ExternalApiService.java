package com.grygierczyk.services;


import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class ExternalApiService {

    private static final String BASE_URL = "https://data.bn.org.pl/api/institutions/bibs.json";
    public String buildApiUrl(String path, Map<String, String> queryParams) {
        // Utwórz obiekt UriComponentsBuilder z bazowym adresem URL
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(BASE_URL);

        if (queryParams != null && !queryParams.isEmpty()) {
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                builder.queryParam(entry.getKey(), entry.getValue());
            }
        }

        return builder.toUriString();
    }
}
