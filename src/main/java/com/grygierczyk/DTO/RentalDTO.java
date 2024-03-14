package com.grygierczyk.DTO;

public class RentalDTO {
    private int clientId;
    private Long bibsItemId;

    public RentalDTO(int clientId, Long bibsItemId) {
        this.clientId = clientId;
        this.bibsItemId = bibsItemId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Long getBibsItemId() {
        return bibsItemId;
    }

    public void setBibsItemId(Long bibsItemId) {
        this.bibsItemId = bibsItemId;
    }
}
