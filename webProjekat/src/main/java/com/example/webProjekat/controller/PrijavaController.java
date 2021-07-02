package com.example.webProjekat.controller;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Prijava;
import com.example.webProjekat.model.Termin;
import com.example.webProjekat.model.dto.PrijavaDTO;
import com.example.webProjekat.model.dto.TerminDTO;
import com.example.webProjekat.service.KorisnikService;
import com.example.webProjekat.service.PrijavaService;
import com.example.webProjekat.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/prijava")
public class PrijavaController {

    private final PrijavaService prijavaService;
    private final KorisnikService korisnikService;
    private final TerminService terminService;

    @Autowired
    public PrijavaController(PrijavaService prijavaService, KorisnikService korisnikService, TerminService terminService){
        this.prijavaService = prijavaService;
        this.korisnikService = korisnikService;
        this.terminService = terminService;
    }


    @PostMapping(value="/{terminID}/{korID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaDTO> createPrijava(@PathVariable Long terminID, @PathVariable Long korID, @RequestBody PrijavaDTO prijavaDTO) throws Exception{
        Prijava prijava = new Prijava(prijavaDTO.getOdradjen(), prijavaDTO.getOcena());        //kada se kreira prijava iniciram na ove vrednosti
        Termin termin = this.terminService.findOne(terminID);
        Korisnik korisnik = this.korisnikService.findOne(korID);

        List<Prijava> prijave = this.prijavaService.findAll();

        for(Prijava temp : prijave){        //ovim sprecavam da se isti clan prijavi za isti termin vise puta
            if(temp.getTermin().getId() == terminID && temp.getKorisnik().getId() == korID){
                //if(temp.getTermin().getSala().getId() == termin.getSala().getId()) { //ovaj if sluzi da ako je isti termin u dve razlicite sale
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                //}
            }
        }

        prijava.setKorisnik(korisnik);
        prijava.setTermin(termin);

        if(termin.getBrojPrijavljenihClanova() >= termin.getSala().getKapacitet()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Integer temp = termin.getBrojPrijavljenihClanova();
        ++temp;
        termin.setBrojPrijavljenihClanova(temp);

        Prijava newPrijava = this.prijavaService.create(prijava);

        PrijavaDTO newPrijavaDTO = new PrijavaDTO(newPrijava.getId(), newPrijava.getOdradjen(), newPrijava.getOcena());

        return new ResponseEntity<>(newPrijavaDTO, HttpStatus.CREATED);
    }

    //pregled prijavljenih a neodradjenih
    @GetMapping(value="/prijavljeni/{korID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getPrijavljeni(@PathVariable Long korID){
        List<Prijava> prijavaList = this.prijavaService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Prijava prijava : prijavaList){
            if(prijava.getKorisnik().getId() == korID){
                if(prijava.getOdradjen() == false) {
                    Termin temp = prijava.getTermin();
                    TerminDTO terminDTO = new TerminDTO(temp.getId(), temp.getBrojPrijavljenihClanova(), temp.getCena(), temp.getVremeTermina(), temp.getTrening().getNaziv(),
                            temp.getTrening().getOpis(), temp.getTrening().getTipTreninga(), temp.getTrening().getTrajanje(), prijava.getId());

                    terminDTOS.add(terminDTO);
                }
            }
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    //pregled odradjenih
    @GetMapping(value="/odradjeni/{korID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getOdradjeni(@PathVariable Long korID){
        List<Prijava> prijavaList = this.prijavaService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Prijava prijava : prijavaList){
            if(prijava.getKorisnik().getId() == korID){
                if(prijava.getOdradjen() == true) {
                    Termin temp = prijava.getTermin();
                    TerminDTO terminDTO = new TerminDTO(temp.getId(), temp.getBrojPrijavljenihClanova(), temp.getCena(), temp.getVremeTermina(), temp.getTrening().getNaziv(),
                            temp.getTrening().getOpis(), temp.getTrening().getTipTreninga(), temp.getTrening().getTrajanje(), prijava.getId());

                    terminDTOS.add(terminDTO);
                }
            }
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    //pregled odradjenih a neocenjenih
    @GetMapping(value="/odradjeniNeocenjeni/{korID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getOdradjeniNeocenjeni(@PathVariable Long korID){
        List<Prijava> prijavaList = this.prijavaService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Prijava prijava : prijavaList){
            if(prijava.getKorisnik().getId() == korID){
                if(prijava.getOdradjen() == true && prijava.getOcena() == 0) {
                    Termin temp = prijava.getTermin();
                    TerminDTO terminDTO = new TerminDTO(temp.getId(), temp.getBrojPrijavljenihClanova(), temp.getCena(), temp.getVremeTermina(), temp.getTrening().getNaziv(),
                            temp.getTrening().getOpis(), temp.getTrening().getTipTreninga(), temp.getTrening().getTrajanje(), prijava.getId());

                    terminDTOS.add(terminDTO);
                }
            }
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    //pregled odradjenih i ocenjenih
    @GetMapping(value="/odradjeniOcenjeni/{korID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getOdradjeniOcenjeni(@PathVariable Long korID){
        List<Prijava> prijavaList = this.prijavaService.findAll();
        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Prijava prijava : prijavaList){
            if(prijava.getKorisnik().getId() == korID){
                if(prijava.getOdradjen() == true && prijava.getOcena() != 0) {
                    Termin temp = prijava.getTermin();
                    TerminDTO terminDTO = new TerminDTO(temp.getId(), temp.getBrojPrijavljenihClanova(), temp.getCena(), temp.getVremeTermina(), temp.getTrening().getNaziv(),
                            temp.getTrening().getOpis(), temp.getTrening().getTipTreninga(), temp.getTrening().getTrajanje(), prijava.getId(), prijava.getOcena());

                    terminDTOS.add(terminDTO);
                }
            }
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deletePrijava(@PathVariable Long id){
        this.prijavaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaDTO> oceniPrijavu(@PathVariable Long id, @RequestBody Integer ocena) throws Exception{
        Prijava prijava = this.prijavaService.findOne(id);
        prijava.setOcena(ocena);

        Prijava updatedPrijava = this.prijavaService.update(prijava);

        PrijavaDTO updatedPrijavaDTO = new PrijavaDTO(updatedPrijava.getId(), updatedPrijava.getOdradjen(), updatedPrijava.getOcena());

        return new ResponseEntity<>(updatedPrijavaDTO, HttpStatus.OK);
    }

}
