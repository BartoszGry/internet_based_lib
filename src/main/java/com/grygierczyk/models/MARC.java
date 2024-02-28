package com.grygierczyk.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MARC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marc")
    private int code;
    private String indicator1;
    private String indicator2;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "marc_id")
    private List<Subfield> subfields;

    public void addSubfield(Subfield subfield) {
        this.subfields.add(subfield);
    }
}