package com.example.webProjekat.controller;

import com.example.webProjekat.model.Korisnik;
import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.FitnessCentarDTO;
import com.example.webProjekat.model.dto.TreningDTO;
import com.example.webProjekat.service.KorisnikService;
import com.example.webProjekat.service.TreningService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/trening")
public class TreningController {

    private final TreningService treningService;
    private final KorisnikService korisnikService;

    @Autowired
    public TreningController(TreningService treningService, KorisnikService korisnikService){
        this.treningService = treningService;
        this.korisnikService = korisnikService;
    }

//    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)      //dobavljanje po id-u
//    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id){
//        Trening trening = this.treningService.findOne(id);
//
//        TreningDTO treningDTO = new TreningDTO();
//        treningDTO.setId(trening.getId());
//        treningDTO.setTipTreninga(trening.getTipTreninga());
//        treningDTO.setNaziv(trening.getNaziv());
//        treningDTO.setTrajanje(trening.getTrajanje());
//        treningDTO.setOpis(trening.getOpis());
//
//        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
//    }

    //dobavljanje liste svih treninga
    @GetMapping( value = "/{korID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(@PathVariable Long korID){
        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Trening trening: treningList){
            if(trening.getKorisnik().getId() == korID) {
                TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());
                treningDTOS.add(treningDTO);
            }
        }
        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/{korID}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> createTrening(@PathVariable Long korID, @RequestBody TreningDTO treningDTO) throws Exception{
        Trening trening = new Trening(treningDTO.getNaziv(), treningDTO.getOpis(), treningDTO.getTipTreninga(), treningDTO.getTrajanje());

        Korisnik korisnik = this.korisnikService.findOne(korID);

        trening.setKorisnik(korisnik);

        Trening newTrening = this.treningService.create(trening);

        TreningDTO newTreningDTO = new TreningDTO(newTrening.getId(), newTrening.getNaziv(), newTrening.getOpis(), newTrening.getTipTreninga(), newTrening.getTrajanje());

        return new ResponseEntity<>(newTreningDTO, HttpStatus.CREATED);

    }

}
