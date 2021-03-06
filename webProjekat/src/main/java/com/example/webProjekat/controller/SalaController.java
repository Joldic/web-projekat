package com.example.webProjekat.controller;

import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;
import com.example.webProjekat.model.Termin;
import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.FitnessCentarDTO;
import com.example.webProjekat.model.dto.SalaDTO;
import com.example.webProjekat.model.dto.TerminDTO;
import com.example.webProjekat.service.FitnessCentarService;
import com.example.webProjekat.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/sala")
public class SalaController {

    private final SalaService salaService;

    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public SalaController(SalaService salaService, FitnessCentarService fitnessCentarService){this.salaService = salaService; this.fitnessCentarService = fitnessCentarService;}


    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> getSalaId(@PathVariable Long id){
        Sala sala = this.salaService.findOne(id);

        SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznakaSale());

        return new ResponseEntity<>(salaDTO, HttpStatus.OK);
    }

    @PostMapping(value ="/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> createSala(@RequestBody SalaDTO salaDTO, @PathVariable Long id) throws Exception{
        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznakaSale());

        FitnessCentar tempFC = fitnessCentarService.findOne(id);

        sala.setFitnessCentar(tempFC);

        Sala newSala = salaService.create(sala);

        SalaDTO newSalaDTO = new SalaDTO(newSala.getId(), newSala.getKapacitet(), newSala.getOznakaSale());

        return new ResponseEntity<>(newSalaDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Long id){
        this.salaService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping(value = "/lista/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<SalaDTO>> getSale(@PathVariable Long id){
//        List<Sala> salaList = this.salaService.findAll();
//
//        List<SalaDTO> salaDTOS = new ArrayList<>();
//
//        for(Sala temp : salaList){
//            FitnessCentar fitnessCentar = temp.getFitnessCentar();
//            if(fitnessCentar.getId() == id){
//                SalaDTO salaDTO = new SalaDTO(temp.getId(), temp.getKapacitet(), temp.getOznakaSale());
//                salaDTOS.add(salaDTO);
//            }
//        }
//
//        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
//    }

    @GetMapping(value ="listaTermina/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminDTO>> getTermini(@PathVariable Long id){
        Sala sala = this.salaService.findOne(id);
        Set<Termin> termini = sala.getTermini();

        Set<TerminDTO> terminDTOS = new HashSet<>();

        for(Termin termin : termini){
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getBrojPrijavljenihClanova(), termin.getCena(),termin.getVremeTermina());
            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/listaTerminaClan/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminDTO>> getTerminiClan(@PathVariable Long id){
        Sala sala = this.salaService.findOne(id);
        Set<Termin> termini = sala.getTermini();

        Set<TerminDTO> terminDTOS = new HashSet<>();

        for(Termin termin : termini){
            Trening trening = termin.getTrening();
            TerminDTO terminDTO = new TerminDTO(termin.getId(), termin.getBrojPrijavljenihClanova(), termin.getCena(), termin.getVremeTermina(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());

            terminDTOS.add(terminDTO);
        }

        return new ResponseEntity<>(terminDTOS, HttpStatus.OK);
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaDTO salaDTO) throws Exception{
        Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznakaSale());
        sala.setId(id);

        Sala updatedSala = this.salaService.update(sala);

        SalaDTO updatedSalaDTO = new SalaDTO(updatedSala.getId(), updatedSala.getKapacitet(), updatedSala.getOznakaSale());

        return new ResponseEntity<>(updatedSalaDTO, HttpStatus.OK);
    }

}
