package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IVeicoliServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/veicoli")
public class VeicoliController {

    private final IVeicoliServices veicoliS;


    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam(required = true) Integer id) throws Exception {
        return ResponseEntity.ok(veicoliS.getById(id));
    }

    @GetMapping("list")
    public ResponseEntity<Object> list() throws Exception {
        return ResponseEntity.ok(veicoliS.list());
    }

    @GetMapping("findByFilter")
    public ResponseEntity<Object> findByFilter(
            @RequestParam(required = false) Integer idVeicolo,
            @RequestParam(required = false) String tipoVeicolo,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modello,
            @RequestParam(required = false) Integer colore,
            @RequestParam(required = false) Integer categoria,
            @RequestParam(required = false) Integer alimentazione
    ) throws Exception {
        return ResponseEntity.ok(veicoliS.findByFilter(idVeicolo, tipoVeicolo, marca, modello, colore, categoria, alimentazione));
    }

    @GetMapping("getByMarcaLikeA")
    public ResponseEntity<Object> getByMarcaLikeA() throws Exception {
        return ResponseEntity.ok(veicoliS.getByMarcaLikeA());
    }

}