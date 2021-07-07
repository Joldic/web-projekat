package com.example.webProjekat.controller;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;
import com.example.webProjekat.model.Termin;
import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.SalaDTO;
import com.example.webProjekat.model.dto.TerminDTO;
import com.example.webProjekat.model.dto.TreningDTO;
import com.example.webProjekat.service.SalaService;
import com.example.webProjekat.service.TerminService;
import com.example.webProjekat.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {
    private final TerminService terminService;
    private final SalaService salaService;
    private final TreningService treningService;

    @Autowired
    public TerminController(TerminService terminService, SalaService salaService, TreningService treningService){
        this.terminService = terminService;
        this.salaService = salaService;
        this.treningService = treningService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> getTerminId(@PathVariable Long id){
        Termin termin = this.terminService.findOne(id);

        TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina());

        return new ResponseEntity<>(terminDTO, HttpStatus.OK);
    }

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


    @PostMapping(value="/{id}/{treningID}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> createTermin(@PathVariable Long id,@PathVariable Long treningID, @RequestBody TerminDTO terminDTO) throws Exception{
        Termin termin = new Termin(terminDTO.getBrojPrijavljenihClanova(), terminDTO.getCena(), terminDTO.getVremeTermina());

        Sala tempSala = this.salaService.findOne(id);
        FitnessCentar fitnessCentar = tempSala.getFitnessCentar();
        Trening trening = this.treningService.findOne(treningID);

        termin.setFitnessCentar(fitnessCentar);
        termin.setSala(tempSala);
        termin.setTrening(trening);

        Termin newTermin = this.terminService.create(termin);

        TerminDTO newTerminDTO = new TerminDTO(newTermin.getId(), newTermin.getBrojPrijavljenihClanova(),newTermin.getCena(), newTermin.getVremeTermina());

        return new ResponseEntity<>(newTerminDTO, HttpStatus.CREATED);
    }

    @PutMapping(value = "/izmeniTermin/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminDTO> updateTermin(@PathVariable Long id, @RequestBody TerminDTO terminDTO) throws Exception{
        Termin termin = new Termin(terminDTO.getCena(), terminDTO.getVremeTermina());
        termin.setId(id);//postavim id

        Termin updatedTermin = this.terminService.update(termin);

        TerminDTO updatedTerminDTO = new TerminDTO(updatedTermin.getId(), updatedTermin.getBrojPrijavljenihClanova(), updatedTermin.getCena(), updatedTermin.getVremeTermina());

        return new ResponseEntity<>(updatedTerminDTO, HttpStatus.OK);
    }


}
