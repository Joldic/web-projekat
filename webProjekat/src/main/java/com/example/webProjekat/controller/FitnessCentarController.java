package com.example.webProjekat.controller;


import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.dto.FitnessCentarDTO;
import com.example.webProjekat.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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


}
