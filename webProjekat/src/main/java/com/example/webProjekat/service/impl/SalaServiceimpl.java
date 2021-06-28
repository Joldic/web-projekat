package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;
import com.example.webProjekat.repository.SalaRepository;
import com.example.webProjekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void delete(Long id) {this.salaRepository.deleteById(id);}

    @Override
    public List<Sala> findAll(){return this.salaRepository.findAll();}

    @Override
    public Sala update(Sala sala) throws Exception {
        Sala salaToUpdate = this.salaRepository.getOne(sala.getId());
        if(salaToUpdate == null){
            throw new Exception("Sala doesnt exist");
        }
        salaToUpdate.setKapacitet(sala.getKapacitet());
        salaToUpdate.setOznakaSale(sala.getOznakaSale());

        Sala savedSala = this.salaRepository.save(salaToUpdate);
        return savedSala;
    }

}
