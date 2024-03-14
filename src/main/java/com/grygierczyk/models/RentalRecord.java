package com.grygierczyk.models;


import jakarta.persistence.*;

import java.time.LocalDate;



@Entity
public class RentalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rental_records")
    private long id;
    private LocalDate rentalDate;
    private LocalDate rentalExpire;
    @ManyToOne
    @JoinColumn(name = "clients_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_bibs_item", nullable = false)
    private BibsItem bibsItem;

    public RentalRecord(LocalDate rentalDate, LocalDate rentalExpire, User client, BibsItem bibsItem) {
        this.rentalDate = rentalDate;
        this.rentalExpire = rentalExpire;
        this.user = client;
        this.bibsItem = bibsItem;
    }

    public RentalRecord() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getRentalExpire() {
        return rentalExpire;
    }

    public void setRentalExpire(LocalDate rentalExpire) {
        this.rentalExpire = rentalExpire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BibsItem getBibsItem() {
        return bibsItem;
    }

    public void setBibsItem(BibsItem bibsItem) {
        this.bibsItem = bibsItem;
    }
}
