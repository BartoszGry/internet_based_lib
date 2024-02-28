package com.grygierczyk.DTO;

import com.grygierczyk.models.BibsItem;

import java.util.ArrayList;

public class BiblitekaNarodowaResponseDTO {

    private String nextPage;
    private ArrayList<BibsItem> bibs;


    public BiblitekaNarodowaResponseDTO(String nextPage, ArrayList<BibsItem> bibs) {
        this.nextPage = nextPage;
        this.bibs = bibs;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public ArrayList<BibsItem> getBibs() {
        return bibs;
    }

    public void setBibs(ArrayList<BibsItem> bibs) {
        this.bibs = bibs;
    }
}
