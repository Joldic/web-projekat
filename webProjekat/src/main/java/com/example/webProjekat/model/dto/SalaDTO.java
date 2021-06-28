package com.example.webProjekat.model.dto;

public class SalaDTO {
    private Long id;
    private Integer kapacitet;
    private String oznakaSale;

    public SalaDTO(){

    }

    public SalaDTO(Long id, Integer kapacitet, String oznakaSale) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznakaSale = oznakaSale;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(Integer kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }
}
