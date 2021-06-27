package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;
import com.example.webProjekat.repository.SalaRepository;
import com.example.webProjekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaServiceimpl implements SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceimpl(SalaRepository salaRepository){this.salaRepository = salaRepository;}

    @Override
    public Sala create(Sala sala) throws Exception{
        if(sala.getId() != null){
            throw new Exception("ID must be null");
        }
        Sala newSala = this.salaRepository.save(sala);
        return newSala;
    }

}
