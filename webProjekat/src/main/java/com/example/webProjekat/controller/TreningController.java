package com.example.webProjekat.controller;

import com.example.webProjekat.model.Trening;
import com.example.webProjekat.model.dto.TreningDTO;
import com.example.webProjekat.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/trening")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
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
}
