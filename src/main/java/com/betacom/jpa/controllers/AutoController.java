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

import com.betacom.jpa.dto.input.AutoReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IAutoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/auto")
public class AutoController {

    private final IAutoServices autoS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) AutoReq req) throws Exception {
        autoS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("created...")
                .build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) AutoReq req) throws Exception {
        autoS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("updated...")
                .build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception {
        autoS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("deleted...")
                .build());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam(required = true) Integer id) throws Exception {
        return ResponseEntity.ok(autoS.getById(id));
    }

    @GetMapping("getByTarga")
    public ResponseEntity<Object> getByTarga(@RequestParam(required = true) String targa) throws Exception {
        return ResponseEntity.ok(autoS.getByTarga(targa));
    }

    @GetMapping("getByTargaLikeA")
    public ResponseEntity<Object> getByTargaLikeA() throws Exception {
        return ResponseEntity.ok(autoS.getByTargaLikeA());
    }

    @GetMapping("list")
    public ResponseEntity<Object> list(
            @RequestParam(required = false) Integer idAuto,
            @RequestParam(required = false) String targa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modello,
            @RequestParam(required = false) Integer colore,
            @RequestParam(required = false) Integer categoria
    ) throws Exception {
        return ResponseEntity.ok(autoS.list(idAuto, targa, marca, modello, colore, categoria));
    }

    @GetMapping("findByFilter")
    public ResponseEntity<Object> findByFilter(
            @RequestParam(required = false) Integer idAuto,
            @RequestParam(required = false) String targa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modello,
            @RequestParam(required = false) Integer colore,
            @RequestParam(required = false) Integer categoria
    ) throws Exception {
        return ResponseEntity.ok(autoS.findByFilter(idAuto, targa, marca, modello, colore, categoria));
    }

}