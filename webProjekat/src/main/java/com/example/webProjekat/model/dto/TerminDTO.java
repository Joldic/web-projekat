package com.example.webProjekat.model.dto;

import java.time.LocalDateTime;

public class TerminDTO {
    private Long id;
    private Integer brojPrijavljenihClanova;
    private Integer cena;
    private LocalDateTime vremeTermina;

    public TerminDTO(){
    }

    public TerminDTO(Long id, Integer brojPrijavljenihClanova, Integer cena, LocalDateTime vremeTermina) {
        this.id = id;
        this.brojPrijavljenihClanova = brojPrijavljenihClanova;
        this.cena = cena;
        this.vremeTermina = vremeTermina;
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
}
