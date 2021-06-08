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


    //Sortiranja
    @Override
    public List<Trening> findBySortTrajanje(){
        List<Trening> trenings = this.treningRepository.findByOrderByTrajanjeAsc();
        return trenings;
    }

    @Override
    public List<Trening> findBySortTrajanjeDesc(){
        return this.treningRepository.findByOrderByTrajanjeDesc();
    }

    @Override
    public List<Trening> findBySortNaziv(){
        List<Trening> trenings = this.treningRepository.findByOrderByNazivAsc();
        return trenings;
    }
    @Override
    public List<Trening> findBySortNazivDesc(){
        return this.treningRepository.findByOrderByNazivDesc();
    }

    @Override
    public List<Trening> findBySortOpis(){
        return this.treningRepository.findByOrderByOpisAsc();
    }
    @Override
    public List<Trening> findBySortOpisDesc(){
        return this.treningRepository.findByOrderByOpisDesc();
    }

    @Override
    public List<Trening> findBySortTipTreninga(){
        return this.treningRepository.findByOrderByTipTreningaAsc();
    }
    @Override
    public List<Trening> findBySortTipTreningaDesc(){
        return this.treningRepository.findByOrderByTipTreningaDesc();
    }

}
