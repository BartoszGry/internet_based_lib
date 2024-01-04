package com.grygierczyk.system_bibioteki;

import java.util.List;

public class MARC {
    private int code;
    private String indicator1;
    private String indicator2;
    private List<Subfield> subfields;

    public void addSubfield(Subfield subfield) {
        this.subfields.add(subfield);
    }
}