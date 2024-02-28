package com.grygierczyk.clients;


import com.grygierczyk.DTO.BiblitekaNarodowaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@Component
public class BibliotekaNarodowaClient {
    @Autowired
    private final RestTemplate restTemplate;
    private final static String author = "author=";
    private final static String title = "title=";
    private final static String publicationYear = "publicationYear=";
    private final static String publisher = "publisher=";
    private final static String kind = "kind=";
    private final String baseUrl = "https://data.bn.org.pl/api/institutions/bibs.json?";

    public BibliotekaNarodowaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public BiblitekaNarodowaResponseDTO fetchByParams(String author, String title, String publicationYear, String publisher, String kind) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParamIfPresent("author", Optional.ofNullable(author))
                .queryParamIfPresent("title", Optional.ofNullable(title))
                .queryParamIfPresent("publicationYear", Optional.ofNullable(publicationYear))
                .queryParamIfPresent("publisher", Optional.ofNullable(publisher))
                .queryParamIfPresent("kind", Optional.ofNullable(kind));

        String url = builder.toUriString();

        return restTemplate.getForObject(url, BiblitekaNarodowaResponseDTO.class);
    }

}
