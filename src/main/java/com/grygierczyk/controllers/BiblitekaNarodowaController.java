package com.grygierczyk.controllers;


import com.grygierczyk.DTO.BiblitekaNarodowaResponseDTO;
import com.grygierczyk.clients.BibliotekaNarodowaClient;
import com.grygierczyk.models.BibsItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib-national")
@CrossOrigin(origins = "http://localhost:5173")
public class BiblitekaNarodowaController {


    private final BibliotekaNarodowaClient bibliotekaNarodowaClient;

    public BiblitekaNarodowaController(BibliotekaNarodowaClient bibliotekaNarodowaClient) {
        this.bibliotekaNarodowaClient = bibliotekaNarodowaClient;
    }

    @GetMapping("/search")
    public BiblitekaNarodowaResponseDTO search(@RequestParam(required = false, name = "id") Long id,
                                               @RequestParam(required = false, name = "author") String author,
                                               @RequestParam(required = false, name = "title") String title,
                                               @RequestParam(required = false, name = "publicationYear") String publicationYear,
                                               @RequestParam(required = false, name = "publisher") String publisher,
                                               @RequestParam(required = false, name = "kind") String kind) {
        return bibliotekaNarodowaClient.fetchByParams(id, author, title, publicationYear, publisher, kind);
    }

    @GetMapping("/list-search")
    public List<BibsItem> listSearch(@RequestParam(required = false, name = "id") Long id,
                                     @RequestParam(required = false, name = "author") String author,
                                     @RequestParam(required = false, name = "title") String title,
                                     @RequestParam(required = false, name = "publicationYear") String publicationYear,
                                     @RequestParam(required = false, name = "publisher") String publisher,
                                     @RequestParam(required = false, name = "kind") String kind) {
        return bibliotekaNarodowaClient.fetchByParamsToList(id, author, title, publicationYear, publisher, kind);
    }


}
