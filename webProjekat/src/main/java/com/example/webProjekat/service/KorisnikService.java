package com.example.webProjekat.service;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;

import java.util.List;

public interface KorisnikService {
    Korisnik findOne(Long id);
    List<Korisnik> findZahtevi(Boolean aktivan, Uloga uloga);
}
