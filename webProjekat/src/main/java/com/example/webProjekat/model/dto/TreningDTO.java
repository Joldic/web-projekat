package com.example.webProjekat.model.dto;

import com.example.webProjekat.model.Trening;

import java.time.LocalDateTime;

public class TreningDTO {
    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private String tipTreninga;

    @Column
    private Integer trajanje; */
    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;
    private Integer trajanje;
    ///////ovo je novo
    private LocalDateTime vremeTermina;
    private Integer cena;

    public TreningDTO(){

    }

//    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, Integer trajanje){
//        this.id = id;
//        this.naziv = naziv;
//        this.opis = opis;
//        this.tipTreninga = tipTreninga;
//        this.trajanje = trajanje;
//    }


    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, LocalDateTime vremeTermina, Integer cena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.vremeTermina = vremeTermina;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getVremeTermina() {
        return vremeTermina;
    }

    public void setVremeTermina(LocalDateTime vremeTermina) {
        this.vremeTermina = vremeTermina;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }
}
