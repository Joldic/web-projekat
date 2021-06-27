package com.example.webProjekat.repository;

import com.example.webProjekat.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findByNaziv(String naziv);

    List<Trening> findByTipTreninga(String tipTreninga);

    List<Trening> findByOpis(String opis);

    List<Trening> findByTrajanje(Integer trajanje);



}
