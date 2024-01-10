package com.grygierczyk.services;

import com.grygierczyk.system_repo.BibsItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BibService {
    private final BibsItemRepository bibsItemRepository;

    @Autowired
    public BibService(BibsItemRepository bibsItemRepository){
        this.bibsItemRepository= bibsItemRepository;
    }

    //nie wiem


}
