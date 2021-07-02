package com.example.webProjekat.service;

import com.example.webProjekat.model.Prijava;

import java.util.List;

public interface PrijavaService {
    Prijava create(Prijava prijava) throws Exception;

    List<Prijava> findAll();

    void delete(Long id);
}
