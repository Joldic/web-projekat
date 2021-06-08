package com.example.webProjekat.service;

import com.example.webProjekat.model.Trening;

import java.util.List;

public interface TreningService {
    Trening findOne(Long id);

    List<Trening> findAll();

    List<Trening> findBySortTrajanje();

    List<Trening> findBySortNaziv();

    List<Trening> findBySortOpis();

    List<Trening> findBySortTipTreninga();

    //opadajuce
    List<Trening> findBySortTrajanjeDesc();

    List<Trening> findBySortNazivDesc();

    List<Trening> findBySortOpisDesc();

    List<Trening> findBySortTipTreningaDesc();

}
