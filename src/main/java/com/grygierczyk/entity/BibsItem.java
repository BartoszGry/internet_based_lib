package com.grygierczyk.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class BibsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String zone;
    private String createdDate;
    private String updatedDate;
    private boolean deleted;
    private String deletedDate;
    private String language;
    private String subject;
    private String subjectPlace;
    private String subjectTime;
    private String subjectWork;
    private String isbnIssn;
    private String author;
    private String placeOfPublication;
    private String location;
    private String title;
    private String udc;
    private String publisher;
    private String kind;
    private String domain;
    private String formOfWork;
    private String genre;
    private String timePeriodOfCreation;
    private String audienceGroup;
    private String demographicGroup;
    private String nationalBibliographyNumber;
    private String publicationYear;
    private String languageOfOriginal;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "BibsItem_id")
    private List<MARC> marcs;

    public void addMARCS(MARC marc) {
        this.marcs.add(marc);
    }

}
