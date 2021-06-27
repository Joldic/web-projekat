package com.example.webProjekat.service;

import com.example.webProjekat.model.Termin;

import java.time.LocalDateTime;
import java.util.List;

public interface TerminService {
    Termin findOne(Long id);

    List<Termin> findAll();

    List<Termin> findBySortCenaASC();

    List<Termin> findBySortCenaDESC();

    List<Termin> findBySortVremeASC();

    List<Termin> findBySortVremeDESC();

}
