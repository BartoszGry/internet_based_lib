package com.grygierczyk.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "bibs_item")
public class BibsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bibs_item")
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectPlace() {
        return subjectPlace;
    }

    public void setSubjectPlace(String subjectPlace) {
        this.subjectPlace = subjectPlace;
    }

    public String getSubjectTime() {
        return subjectTime;
    }

    public void setSubjectTime(String subjectTime) {
        this.subjectTime = subjectTime;
    }

    public String getSubjectWork() {
        return subjectWork;
    }

    public void setSubjectWork(String subjectWork) {
        this.subjectWork = subjectWork;
    }

    public String getIsbnIssn() {
        return isbnIssn;
    }

    public void setIsbnIssn(String isbnIssn) {
        this.isbnIssn = isbnIssn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    public void setPlaceOfPublication(String placeOfPublication) {
        this.placeOfPublication = placeOfPublication;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUdc() {
        return udc;
    }

    public void setUdc(String udc) {
        this.udc = udc;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getFormOfWork() {
        return formOfWork;
    }

    public void setFormOfWork(String formOfWork) {
        this.formOfWork = formOfWork;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTimePeriodOfCreation() {
        return timePeriodOfCreation;
    }

    public void setTimePeriodOfCreation(String timePeriodOfCreation) {
        this.timePeriodOfCreation = timePeriodOfCreation;
    }

    public String getAudienceGroup() {
        return audienceGroup;
    }

    public void setAudienceGroup(String audienceGroup) {
        this.audienceGroup = audienceGroup;
    }

    public String getDemographicGroup() {
        return demographicGroup;
    }

    public void setDemographicGroup(String demographicGroup) {
        this.demographicGroup = demographicGroup;
    }

    public String getNationalBibliographyNumber() {
        return nationalBibliographyNumber;
    }

    public void setNationalBibliographyNumber(String nationalBibliographyNumber) {
        this.nationalBibliographyNumber = nationalBibliographyNumber;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getLanguageOfOriginal() {
        return languageOfOriginal;
    }

    public void setLanguageOfOriginal(String languageOfOriginal) {
        this.languageOfOriginal = languageOfOriginal;
    }
}
