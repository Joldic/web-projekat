package com.example.webProjekat.model.dto;

import java.time.LocalDateTime;

public class TerminDTO {
    private Long id;
    private Integer brojPrijavljenihClanova;
    private Integer cena;
    private LocalDateTime vremeTermina;


    private String naziv;
    private String opis;
    private String tipTreninga;
    private Integer trajanje;


    public TerminDTO(){
    }

    public TerminDTO(Long id, Integer brojPrijavljenihClanova, Integer cena, LocalDateTime vremeTermina) {
        this.id = id;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.vremeTermina = vremeTermina;
    }

    public TerminDTO(Long id, Integer brojPrijavljenihClanova, Integer cena, LocalDateTime vremeTermina, String naziv, String opis, String tipTreninga, Integer trajanje) {
        this.id = id;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.vremeTermina = vremeTermina;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBrojPrijavljenihClanova() {
        return brojPrijavljenihClanova;
    }

    public void setBrojPrijavljenihClanova(Integer brojPrijavljenihClanova) {
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }

    public LocalDateTime getVremeTermina() {
        return vremeTermina;
    }

    public void setVremeTermina(LocalDateTime vremeTermina) {
        this.vremeTermina = vremeTermina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }
}
