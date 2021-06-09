package com.example.webProjekat.service.impl;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;
import com.example.webProjekat.repository.KorisnikRepository;
import com.example.webProjekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceimpl implements KorisnikService {
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceimpl(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik findOne(Long id){
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    @Override
    public List<Korisnik> findZahtevi(Boolean aktivan, Uloga uloga){
        List<Korisnik> korisnici = this.korisnikRepository.findByAktivanAndUloga(aktivan, uloga);
        return korisnici;
    }
}
