package com.example.webProjekat.service;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;

import java.util.List;

public interface SalaService {
    Sala create(Sala sala) throws Exception;

    void delete(Long id);

    List<Sala> findAll();

    Sala update(Sala sala) throws Exception;
}
