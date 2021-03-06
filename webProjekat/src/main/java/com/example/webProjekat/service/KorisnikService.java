package com.example.webProjekat.service;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;

import java.util.List;

public interface KorisnikService {
    Korisnik findOne(Long id);
    List<Korisnik> findZahtevi(Boolean aktivan, Uloga uloga);

    Korisnik update(Korisnik korisnik) throws Exception;

    Korisnik updateClan(Korisnik korisnik) throws Exception;

    Korisnik create(Korisnik korisnik) throws Exception;

    Korisnik createTrener(Korisnik korisnik) throws Exception;

    Korisnik findUsernamePassword(String korisnickoIme, String lozinka);

    List<Korisnik> findAll();

    void delete(Long id);
}
