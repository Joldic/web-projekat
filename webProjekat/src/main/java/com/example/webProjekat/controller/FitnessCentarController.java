package com.example.webProjekat.controller;


import com.example.webProjekat.model.FitnessCentar;
import com.example.webProjekat.model.dto.FitnessCentarDTO;
import com.example.webProjekat.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/fitnesscentar")
public class FitnessCentarController {
    private final FitnessCentarService fitnessCentarService;

    @Autowired
    public FitnessCentarController(FitnessCentarService fitnessCentarService){
        this.fitnessCentarService = fitnessCentarService;
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


}
