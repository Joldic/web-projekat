package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.repository.FitnessCentarRepository;
import com.example.webProjekat.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessCentarServiceimpl implements FitnessCentarService {
    private final FitnessCentarRepository fitnessCentarRepository;

    @Autowired
    public FitnessCentarServiceimpl(FitnessCentarRepository fitnessCentarRepository){
        this.fitnessCentarRepository = fitnessCentarRepository;
    }

    @Override
    public FitnessCentar findOne(Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarRepository.getOne(id);
        return fitnessCentar;
    }

    @Override
    public List<FitnessCentar> findAll(){
        List<FitnessCentar> fitnessCentars = this.fitnessCentarRepository.findAll();
        return fitnessCentars;
    }

    @Override
    public FitnessCentar create(FitnessCentar fitnessCentar) throws Exception{
        if(fitnessCentar.getId() != null){
            throw new Exception("ID must be null");
        }
        FitnessCentar newFitnessCentar = this.fitnessCentarRepository.save(fitnessCentar);
        return newFitnessCentar;
    }

    @Override
    public void delete(Long id){
        this.fitnessCentarRepository.deleteById(id);
    }

}
