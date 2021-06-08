package com.example.webProjekat.controller;

import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.TreningDTO;
import com.example.webProjekat.service.TreningService;
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

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)      //dobavljanje po id-u
    public ResponseEntity<TreningDTO> getTrening(@PathVariable("id") Long id){
        Trening trening = this.treningService.findOne(id);

        TreningDTO treningDTO = new TreningDTO();
        treningDTO.setId(trening.getId());
        treningDTO.setTipTreninga(trening.getTipTreninga());
        treningDTO.setNaziv(trening.getNaziv());
        treningDTO.setTrajanje(trening.getTrajanje());
        treningDTO.setOpis(trening.getOpis());

        return new ResponseEntity<>(treningDTO, HttpStatus.OK);
    }

    //dobavljanje liste svih treninga
    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> getTreninzi(){
        List<Trening> treningList = this.treningService.findAll();

        List<TreningDTO> treningDTOS = new ArrayList<>();

        for(Trening trening: treningList){
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());
            treningDTOS.add(treningDTO);
        }
        return new ResponseEntity<>(treningDTOS, HttpStatus.OK);
    }

    @GetMapping("/naziv")
    public List<Trening> getTreningsByNaziv(@RequestParam String naziv){
        return treningService.findByName(naziv);
    }

}
