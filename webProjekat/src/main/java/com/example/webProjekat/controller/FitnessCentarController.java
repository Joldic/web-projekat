package com.example.webProjekat.controller;


import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.Sala;
import com.example.webProjekat.model.dto.FitnessCentarDTO;
import com.example.webProjekat.model.dto.SalaDTO;
import com.example.webProjekat.service.FitnessCentarService;
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
@RequestMapping(value = "/api/fitnesscentar")
public class FitnessCentarController {
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public FitnessCentarController(FitnessCentarService fitnessCentarService){
        this.fitnessCentarService = fitnessCentarService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> getFitnessCentar(@PathVariable("id") Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);

        FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO();
        fitnessCentarDTO.setId(fitnessCentar.getId());
        fitnessCentarDTO.setNaziv(fitnessCentar.getNaziv());
        fitnessCentarDTO.setAdresa(fitnessCentar.getAdresa());
        fitnessCentarDTO.setBrojTelefonaCentrale(fitnessCentar.getBrojTelefonaCentrale());
        fitnessCentarDTO.seteMail(fitnessCentar.geteMail());

        return new ResponseEntity<>(fitnessCentarDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> getFitnessCentars(){
        List<FitnessCentar> fitnessCentarList = this.fitnessCentarService.findAll();

        List<FitnessCentarDTO> fitnessCentarDTOS = new ArrayList<>();

        for(FitnessCentar fitnessCentar : fitnessCentarList){
            FitnessCentarDTO fitnessCentarDTO = new FitnessCentarDTO(fitnessCentar.getId(), fitnessCentar.getNaziv(),fitnessCentar.getAdresa(),
                    fitnessCentar.getBrojTelefonaCentrale(), fitnessCentar.geteMail());
            fitnessCentarDTOS.add(fitnessCentarDTO);
        }

        return new ResponseEntity<>(fitnessCentarDTOS, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> createFitnessCentar(@RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{
        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getNaziv(),fitnessCentarDTO.getAdresa(), fitnessCentarDTO.getBrojTelefonaCentrale(),
                fitnessCentarDTO.geteMail());

        FitnessCentar newFitnessCentar = fitnessCentarService.create(fitnessCentar);

        FitnessCentarDTO newFitnessCentarDTO = new FitnessCentarDTO(newFitnessCentar.getId(), newFitnessCentar.getNaziv(),
                newFitnessCentar.getAdresa(), newFitnessCentar.getBrojTelefonaCentrale(), newFitnessCentar.geteMail());

        return new ResponseEntity<>(newFitnessCentarDTO, HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteFitnessCentar(@PathVariable Long id){
        this.fitnessCentarService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value="listaSala/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<SalaDTO>> getSale(@PathVariable Long id){
        FitnessCentar fitnessCentar = this.fitnessCentarService.findOne(id);
        Set<Sala> salaList = fitnessCentar.getSale();

        Set<SalaDTO> salaDTOS = new HashSet<>();

        for(Sala sala : salaList){
            SalaDTO salaDTO = new SalaDTO(sala.getId(), sala.getKapacitet(), sala.getOznakaSale());
            salaDTOS.add(salaDTO);
        }

        return new ResponseEntity<>(salaDTOS, HttpStatus.OK);
    }

    @PutMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> updateFC(@PathVariable Long id, @RequestBody FitnessCentarDTO fitnessCentarDTO) throws Exception{
        FitnessCentar fitnessCentar = new FitnessCentar(fitnessCentarDTO.getNaziv(),fitnessCentarDTO.getAdresa(), fitnessCentarDTO.getBrojTelefonaCentrale(),
                fitnessCentarDTO.geteMail() );

        fitnessCentar.setId(id);

        FitnessCentar updatedFC = this.fitnessCentarService.update(fitnessCentar);

        FitnessCentarDTO updatedfcDTO = new FitnessCentarDTO(updatedFC.getId(), updatedFC.getNaziv(), updatedFC.getAdresa(), updatedFC.getBrojTelefonaCentrale(),
                updatedFC.geteMail());

        return new ResponseEntity<>(updatedfcDTO, HttpStatus.OK);
    }

}
