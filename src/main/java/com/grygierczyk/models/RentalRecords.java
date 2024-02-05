//package com.grygierczyk.entity;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//
//
//@Entity
//public class RentalRecords {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private LocalDate rentalDate;
//    private LocalDate rebtalExpire;
//    @ManyToOne
//    @JoinColumn(name = "clients_id", nullable = false)
//    private User client;
//
//    @ManyToOne
//    @JoinColumn(name = "bibsItem_id", nullable = false)
//    private BibsItem bibsItem;
//
//}
