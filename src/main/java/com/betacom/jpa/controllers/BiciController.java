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

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IBiciServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/bici")
public class BiciController {

    private final IBiciServices biciS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) BiciReq req) throws Exception {
        biciS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("created...")
                .build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) BiciReq req) throws Exception {
        biciS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("updated...")
                .build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception {
        biciS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("deleted...")
                .build());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam(required = true) Integer id) throws Exception {
        return ResponseEntity.ok(biciS.getById(id));
    }

    @GetMapping("getByMarcaLikeA")
    public ResponseEntity<Object> getByMarcaLikeA() throws Exception {
        return ResponseEntity.ok(biciS.getByMarcaLikeA());
    }

    @GetMapping("list")
    public ResponseEntity<Object> list(
            @RequestParam(required = false) Integer idBici,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modello,
            @RequestParam(required = false) Integer colore,
            @RequestParam(required = false) Integer categoria,
            @RequestParam(required = false) Boolean pieghevole
    ) throws Exception {
        return ResponseEntity.ok(biciS.list(idBici, marca, modello, colore, categoria, pieghevole));
    }

}