package com.example.webProjekat.controller;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;
import com.example.webProjekat.model.dto.KorisnikDTO;
import com.example.webProjekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable("id") Long id){
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();
        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikDTO.setLozinka(korisnik.getLozinka());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setKontaktTelefon(korisnik.getKontaktTelefon());
        korisnikDTO.seteMail(korisnik.geteMail());
        korisnikDTO.setDatumRodjenja(korisnik.getDatumRodjenja());
        korisnikDTO.setUloga(korisnik.getUloga());
        korisnikDTO.setAktivan(korisnik.getAktivan());
        korisnikDTO.setProsecnaOcena(korisnik.getProsecnaOcena());

        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

    @GetMapping("/zahteviTreneri")
    public ResponseEntity<List<KorisnikDTO>> getZahteviTreneri(){
        List<Korisnik> korisnikList = this.korisnikService.findZahtevi(false, Uloga.TRENER);

        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

        for(Korisnik korisnik : korisnikList){
            KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(), korisnik.getLozinka(),korisnik.getIme(),korisnik.getPrezime(),korisnik.getKontaktTelefon(),
                    korisnik.geteMail(), korisnik.getDatumRodjenja(), korisnik.getUloga(), korisnik.getAktivan(), korisnik.getProsecnaOcena());

            korisnikDTOS.add(korisnikDTO);
        }

        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
    }
}
