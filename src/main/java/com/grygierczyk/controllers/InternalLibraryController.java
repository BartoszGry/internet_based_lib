package com.grygierczyk.controllers;

import com.grygierczyk.DTO.BiblitekaNarodowaResponseDTO;
import com.grygierczyk.models.BibsItem;
import com.grygierczyk.services.BibService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lib-internal")
@CrossOrigin(origins = "http://localhost:5173")
public class InternalLibraryController {

    private final BibService bibService;

    public InternalLibraryController(BibService bibService) {
        this.bibService = bibService;
    }

    @GetMapping("/search")
    public List<BibsItem> search(@RequestParam(required = false,name = "author") String author,
                                 @RequestParam(required = false,name = "title") String title,
                                 @RequestParam(required = false,name = "publicationYear") String publicationYear,
                                 @RequestParam(required = false,name = "publisher") String publisher,
                                 @RequestParam(required = false,name = "kind") String kind){
        return bibService.fetchByParams(author,title,publicationYear,publisher,kind);
    }

}
