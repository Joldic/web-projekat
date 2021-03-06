package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.Termin;
import com.example.webProjekat.repository.TerminRepository;
import com.example.webProjekat.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TerminServiceimpl implements TerminService {

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceimpl(TerminRepository terminRepository){this.terminRepository = terminRepository;}

    @Override
    public Termin findOne(Long id){
        Termin termin = this.terminRepository.getOne(id);
        return termin;
    }

    @Override
    public List<Termin> findAll(){
        return this.terminRepository.findAll();
    }

    @Override
    public List<Termin>  findBySortCenaASC(){
        return this.terminRepository.findByOrderByCenaAsc();
    }

    @Override
    public List<Termin> findBySortCenaDESC(){
        return this.terminRepository.findByOrderByCenaDesc();
    }

    @Override
    public List<Termin> findBySortVremeASC(){ return this.terminRepository.findByOrderByVremeTerminaAsc(); }

    @Override
    public List<Termin> findBySortVremeDESC(){return this.terminRepository.findByOrderByVremeTerminaDesc();}

    @Override
    public Termin create(Termin termin) throws Exception{
        if(termin.getId() != null){
            throw new Exception("ID must be null");
        }
        Termin newTermin = this.terminRepository.save(termin);
        return newTermin;
    }

    @Override
    public Termin update(Termin termin) throws Exception{
        Termin terminToUpdate = this.terminRepository.getOne(termin.getId());
        if(terminToUpdate == null){
            throw new Exception("Termin doesn't exist");
        }

        terminToUpdate.setCena(termin.getCena());
        terminToUpdate.setVremeTermina(termin.getVremeTermina());

        Termin savedTermin = this.terminRepository.save(terminToUpdate);
        return savedTermin;
    }

}
