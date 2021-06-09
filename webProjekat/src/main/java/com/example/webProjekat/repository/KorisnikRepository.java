package com.example.webProjekat.repository;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    List<Korisnik> findByAktivanAndUloga(Boolean aktivan, Uloga uloga);

    Korisnik findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);
}
