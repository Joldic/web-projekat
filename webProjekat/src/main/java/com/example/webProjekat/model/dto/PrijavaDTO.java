package com.example.webProjekat.model.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PrijavaDTO {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private Boolean odradjen;//gledam da li mi je trening uradjen ili ne
//
//    @Column
//    private Integer ocena;

    private Long id;
    private Boolean odradjen;
    private Integer ocena;

    public PrijavaDTO(Long id, Boolean odradjen, Integer ocena) {
        this.id = id;
        this.odradjen = odradjen;
        this.ocena = ocena;
    }

    public PrijavaDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOdradjen() {
        return odradjen;
    }

    public void setOdradjen(Boolean odradjen) {
        this.odradjen = odradjen;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }
}
