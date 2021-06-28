package com.example.webProjekat.service;

import com.example.webProjekat.model.FitnessCentar;

import java.util.List;

public interface FitnessCentarService {

    FitnessCentar findOne(Long id);

    List<FitnessCentar> findAll();

    FitnessCentar create(FitnessCentar fitnessCentar) throws Exception;

    void delete(Long id);

    FitnessCentar update(FitnessCentar fitnessCentar) throws Exception;
}
