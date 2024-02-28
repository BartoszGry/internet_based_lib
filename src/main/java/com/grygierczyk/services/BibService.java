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

    public List<BibsItem> findByTitle(String title) {
        return bibsItemRepository.findByTitle(title);
    }

    public List<BibsItem> findByAuthor(String author) {
        return bibsItemRepository.findByAuthor(author);
    }

    public List<BibsItem> findByPublicationYear(String publicationYear) {
        return bibsItemRepository.findByPublicationYear(publicationYear);
    }

    public List<BibsItem> findByPublisher(String publisher) {
        return bibsItemRepository.findByPublisher(publisher);
    }

    public List<BibsItem> findByKind(String kind) {
        return bibsItemRepository.findByKind(kind);
    }


}
