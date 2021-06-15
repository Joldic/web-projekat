package com.example.webProjekat.controller;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Uloga;
import com.example.webProjekat.model.dto.KorisnikDTO;
import com.example.webProjekat.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value="/zahteviTreneri/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> updateKorisnik(@PathVariable("id") Long id) throws Exception{
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(),korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getIme(),
                korisnik.getPrezime(),korisnik.getKontaktTelefon(),korisnik.geteMail(),korisnik.getDatumRodjenja(),korisnik.getUloga(),korisnik.getAktivan(), korisnik.getProsecnaOcena());

        Korisnik updatedKorisnik = korisnikService.update(korisnik);

        KorisnikDTO updatedKorisnikDTO = new KorisnikDTO(updatedKorisnik.getId(), updatedKorisnik.getKorisnickoIme(),
                updatedKorisnik.getLozinka(),updatedKorisnik.getIme(),updatedKorisnik.getPrezime(),updatedKorisnik.getKontaktTelefon(),
                updatedKorisnik.geteMail(),updatedKorisnik.getDatumRodjenja(),updatedKorisnik.getUloga(),updatedKorisnik.getAktivan(),updatedKorisnik.getProsecnaOcena());

        return new ResponseEntity<>(updatedKorisnikDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteKorisnik(@PathVariable Long id){
        this.korisnikService.delete(id);

        //204 NO_content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value="/registracijaKorisnika", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> createKorisnik(@RequestBody KorisnikDTO korisnikDTO) throws Exception{

        Korisnik korisnik = new Korisnik(korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka(), korisnikDTO.getIme(), korisnikDTO.getPrezime(),
                korisnikDTO.getKontaktTelefon(),korisnikDTO.geteMail(),korisnikDTO.getDatumRodjenja(),Uloga.CLAN,true,
                0.0);

        Korisnik newKorisnik = korisnikService.create(korisnik);

        KorisnikDTO newKorisnikDTO = new KorisnikDTO(newKorisnik.getId(), newKorisnik.getKorisnickoIme(),newKorisnik.getLozinka(), newKorisnik.getIme(),
                newKorisnik.getPrezime(), newKorisnik.getKontaktTelefon(),newKorisnik.geteMail(),newKorisnik.getDatumRodjenja(),newKorisnik.getUloga(),
                newKorisnik.getAktivan(),newKorisnik.getProsecnaOcena());

        return new ResponseEntity<>(newKorisnikDTO, HttpStatus.CREATED);
    }

    @PostMapping(value="/registracijaTrenera", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> createTrener(@RequestBody KorisnikDTO korisnikDTO) throws Exception{
        Korisnik korisnik = new Korisnik(korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka(), korisnikDTO.getIme(), korisnikDTO.getPrezime(),
                korisnikDTO.getKontaktTelefon(),korisnikDTO.geteMail(),korisnikDTO.getDatumRodjenja(),Uloga.TRENER,false,
                0.0);
        Korisnik newKorisnik = korisnikService.create(korisnik);

        KorisnikDTO newKorisnikDTO = new KorisnikDTO(newKorisnik.getId(), newKorisnik.getKorisnickoIme(),newKorisnik.getLozinka(), newKorisnik.getIme(),
                newKorisnik.getPrezime(), newKorisnik.getKontaktTelefon(),newKorisnik.geteMail(),newKorisnik.getDatumRodjenja(),newKorisnik.getUloga(),
                newKorisnik.getAktivan(),newKorisnik.getProsecnaOcena());

        return new ResponseEntity<>(newKorisnikDTO, HttpStatus.CREATED);

    }
    @GetMapping(value="/{korisnickoIme}/{lozinka}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> checkKorisnik(@PathVariable String korisnickoIme, @PathVariable String lozinka) {
        Korisnik korisnik = this.korisnikService.findUsernamePassword(korisnickoIme, lozinka);

        if(korisnik == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  //404 not found
        }
        if(!korisnik.getAktivan()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//ako nije aktivan
        }
        KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(),korisnik.getLozinka(),korisnik.getIme(), korisnik.getPrezime(),
                korisnik.getKontaktTelefon(), korisnik.geteMail(), korisnik.getDatumRodjenja(),korisnik.getUloga(), korisnik.getAktivan(), korisnik.getProsecnaOcena());

        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

    @GetMapping(value="/Uloga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnikIdUloga(@PathVariable("id") Long id){
        Korisnik korisnik = this.korisnikService.findOne(id);
      //  if(korisnik.getUloga() != Uloga.ADMINISTRATOR){
       //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);//mozda i bad request treba
      //  }
        KorisnikDTO korisnikDTO = new KorisnikDTO(korisnik.getId(), korisnik.getKorisnickoIme(),korisnik.getLozinka(), korisnik.getIme(),
                korisnik.getPrezime(), korisnik.getKontaktTelefon(), korisnik.geteMail(), korisnik.getDatumRodjenja(), korisnik.getUloga(),
                korisnik.getAktivan(), korisnik.getProsecnaOcena());
        if(korisnik.getUloga() != Uloga.ADMINISTRATOR){
            return new ResponseEntity<>(korisnikDTO, HttpStatus.NOT_FOUND);//mozda i bad request treba
        }

        return new ResponseEntity<>(korisnikDTO,HttpStatus.OK);
    }
}
