package com.example.webProjekat.repository;

import com.example.webProjekat.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findByNazivOrderByNazivAsc(String naziv);

    List<Trening> findByTipTreningaOrderByTipTreningaAsc(String tipTreninga);

    List<Trening> findByOpisOrderByOpisAsc(String opis);

    List<Trening> findByTrajanjeOrderByTrajanjeAsc(Integer trajanje);     // ovo mozda i ne treba ***

}
