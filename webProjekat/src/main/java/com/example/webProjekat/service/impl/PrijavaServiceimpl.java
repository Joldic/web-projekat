package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.Prijava;
import com.example.webProjekat.repository.PrijavaRepository;
import com.example.webProjekat.service.PrijavaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrijavaServiceimpl implements PrijavaService {
    private final PrijavaRepository prijavaRepository;

    @Autowired
    public PrijavaServiceimpl(PrijavaRepository prijavaRepository){
        this.prijavaRepository = prijavaRepository;
    }

    @Override
    public Prijava create(Prijava prijava) throws Exception{
        if(prijava.getId() != null){
            throw new Exception("ID must be null");
        }
        Prijava newPrijava = this.prijavaRepository.save(prijava);

        return newPrijava;
    }

    @Override
    public List<Prijava> findAll(){
        return this.prijavaRepository.findAll();
    }

}
