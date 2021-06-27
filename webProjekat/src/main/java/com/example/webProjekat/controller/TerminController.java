package com.example.webProjekat.controller;

import com.example.webProjekat.model.Termin;
import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.TerminDTO;
import com.example.webProjekat.model.dto.TreningDTO;
import com.example.webProjekat.service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {
    private final TerminService terminService;
    @Autowired
    public TerminController(TerminService terminService){this.terminService = terminService;}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TerminDTO>> getTermini(){
        List<Termin> terminList = this.terminService.findAll();

        List<TerminDTO> terminDTOS = new ArrayList<>();

        for(Termin termin : terminList){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }
    ////Treninzi preko termina
    @GetMapping(value = "/proba", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(){
        List<Termin> terminList = this.terminService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Termin termin : terminList){
            Trening tempTrening = termin.getTrening();
            TreningDTO treningDTO = new TreningDTO(tempTrening.getId(), tempTrening.getNaziv(), tempTrening.getOpis(), tempTrening.getTipTreninga(),
                    tempTrening.getTrajanje(),
                    termin.getVremeTermina(), termin.getCena());
            treningDTOS.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }
    //
    @GetMapping("/cenaASC")
    public ResponseEntity<List<TerminDTO>> getTerminiSortedByCenaASC(){
        List<Termin> terminList = this.terminService.findBySortCenaASC();

        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Termin termin: terminList){
            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping("/cenaDESC")
    public ResponseEntity<List<TerminDTO>> getTerminiSortedByCenaDESC(){
        List<Termin> terminList = this.terminService.findBySortCenaDESC();

        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Termin termin: terminList){
            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping("/vremeASC")
    public ResponseEntity<List<TerminDTO>> getTerminiSortedByVremeASC(){
        List<Termin> terminList = this.terminService.findBySortVremeASC();

        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Termin termin: terminList){
            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping("/vremeDESC")
    public ResponseEntity<List<TerminDTO>> getTerminiSortedByVremeDESC(){
        List<Termin> terminList = this.terminService.findBySortVremeDESC();

        List<TerminDTO> terminDTOS = new ArrayList<>();
        for(Termin termin: terminList){
            TerminDTO terminDTO = new TerminDTO(termin.getId(),termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }
        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }


}
