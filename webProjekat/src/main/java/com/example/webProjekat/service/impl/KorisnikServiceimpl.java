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

    @Override
    public Korisnik update(Korisnik korisnik) throws Exception{
        Korisnik korisnikToUpdate = this.korisnikRepository.getOne(korisnik.getId());
        if(korisnikToUpdate == null){
            throw new Exception("Korisnik doesn't exist!");
        }
        korisnikToUpdate.setAktivan(true);

        Korisnik savedKorisnik = this.korisnikRepository.save(korisnikToUpdate);
        return savedKorisnik;
    }
    @Override
    public void delete(Long id){this.korisnikRepository.deleteById(id);}

    @Override
    public Korisnik create(Korisnik korisnik) throws Exception{
        if(korisnik.getId() != null){
            throw new Exception("ID must be null");
        }
        Korisnik newKorisnik = this.korisnikRepository.save(korisnik);
        return newKorisnik;
    }

    @Override
    public Korisnik createTrener(Korisnik korisnik) throws Exception{
        if(korisnik.getId() != null){
            throw new Exception("ID must be null");
        }
        Korisnik newKorisnik = this.korisnikRepository.save(korisnik);
        return newKorisnik;
    }

    @Override
    public  Korisnik findUsernamePassword(String korisnickoIme, String lozinka){
        Korisnik korisnik = this.korisnikRepository.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka);
        return korisnik;
    }

    @Override
    public List<Korisnik> findAll(){
        return this.korisnikRepository.findAll();
    }

}
