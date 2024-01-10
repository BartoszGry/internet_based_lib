package com.grygierczyk.entity;

import jakarta.persistence.*;

@Entity
public class Subfield {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Character code;
    private String value;

    @ManyToOne
    @JoinColumn(name = "marc_id")
    private MARC marc;


    public Character getCode() {
        return code;
    }

    public void setCode(Character code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
