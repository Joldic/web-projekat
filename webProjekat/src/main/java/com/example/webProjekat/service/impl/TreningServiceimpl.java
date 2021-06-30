package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.Trening;
import com.example.webProjekat.repository.TreningRepository;
import com.example.webProjekat.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningServiceimpl implements TreningService {
    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceimpl(TreningRepository treningRepository){
        this.treningRepository = treningRepository;
    }

    @Override
    public Trening findOne(Long id){
        Trening trening = this.treningRepository.getOne(id);
        return trening;
    }

    @Override
    public List<Trening> findAll(){
        List<Trening> trenings = this.treningRepository.findAll();
        return  trenings;
    }

    @Override
    public  Trening create(Trening trening) throws Exception{
        if(trening.getId() != null){
            throw new Exception("ID must be null");
        }
        Trening newTrening = this.treningRepository.save(trening);
        return newTrening;
    }



}
