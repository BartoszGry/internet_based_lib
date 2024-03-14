package com.grygierczyk.DTO;

import java.time.LocalDate;
import java.util.Date;

public class RentalResponseDTO {
    private String email;
    private String author;
    private String title;
    private Long bookId;
    private LocalDate rentalDate;
    private LocalDate expireDate;

    public RentalResponseDTO(String email, String author, String title, Long bookId, LocalDate rentalDate, LocalDate expireDate) {
        this.email = email;
        this.author = author;
        this.title = title;
        this.bookId = bookId;
        this.rentalDate = rentalDate;
        this.expireDate = expireDate;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }
}
