package com.grygierczyk.services;

import com.grygierczyk.models.BibsItem;
import com.grygierczyk.system_repo.BibsItemRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BibService {
    private final BibsItemRepository bibsItemRepository;

    public BibService(BibsItemRepository bibsItemRepository) {
        this.bibsItemRepository = bibsItemRepository;
    }
    public List<BibsItem> fetchByParams(Long id,String author, String title, String publicationYear, String publisher, String kind) {

        if (author != null) {
            return bibsItemRepository.findByAuthor(author);
        } else if (title != null) {
            return bibsItemRepository.findByTitle(title);
        }else if (id != null) {
            return bibsItemRepository.findById(id);
        } else if (publicationYear != null) {
            return bibsItemRepository.findByPublicationYear(publicationYear);
        } else if (publisher != null) {
            return bibsItemRepository.findByPublisher(publisher);
        } else if (kind != null) {
            return bibsItemRepository.findByKind(kind);
        } else {
            throw new IllegalArgumentException("Nie podano żadnych kryteriów wyszukiwania.");
        }
    }





}
