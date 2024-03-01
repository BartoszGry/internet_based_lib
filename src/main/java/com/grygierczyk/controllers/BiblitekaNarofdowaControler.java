package com.grygierczyk.controllers;



import com.grygierczyk.DTO.BiblitekaNarodowaResponseDTO;
import com.grygierczyk.clients.BibliotekaNarodowaClient;
import com.grygierczyk.models.BibsItem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib-national")
@CrossOrigin(origins = "http://localhost:5173")
public class BiblitekaNarofdowaControler {


    private final BibliotekaNarodowaClient bibliotekaNarodowaClient;

    public BiblitekaNarofdowaControler(BibliotekaNarodowaClient bibliotekaNarodowaClient) {
        this.bibliotekaNarodowaClient = bibliotekaNarodowaClient;
    }

    @GetMapping("/search")
    public BiblitekaNarodowaResponseDTO search(@RequestParam(required = false,name = "author") String author,
                                 @RequestParam(required = false,name = "title") String title,
                                 @RequestParam(required = false,name = "publicationYear") String publicationYear,
                                 @RequestParam(required = false,name = "publisher") String publisher,
                                 @RequestParam(required = false,name = "kind") String kind){
        return bibliotekaNarodowaClient.fetchByParams(author,title,publicationYear,publisher,kind);
    }
    @GetMapping("/list-search")
    public List<BibsItem> listSearch(@RequestParam(required = false,name = "author") String author,
                                               @RequestParam(required = false,name = "title") String title,
                                               @RequestParam(required = false,name = "publicationYear") String publicationYear,
                                               @RequestParam(required = false,name = "publisher") String publisher,
                                               @RequestParam(required = false,name = "kind") String kind){
        return bibliotekaNarodowaClient.fetchByParamsToList(author,title,publicationYear,publisher,kind);
    }




}
