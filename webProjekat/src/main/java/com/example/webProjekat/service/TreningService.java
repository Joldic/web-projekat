package com.example.webProjekat.service;

import com.example.webProjekat.model.Trening;

import java.util.List;

public interface TreningService {
    Trening findOne(Long id);

    List<Trening> findAll();



}
