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

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.output.ResponseDTO;
import com.betacom.jpa.services.interfaces.IMotoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/moto")
public class MotoController {

    private final IMotoServices motoS;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> create(@RequestBody(required = true) MotoReq req) throws Exception {
        motoS.create(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("created...")
                .build());
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> update(@RequestBody(required = true) MotoReq req) throws Exception {
        motoS.update(req);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("updated...")
                .build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable(required = true) Integer id) throws Exception {
        motoS.delete(id);
        return ResponseEntity.ok(ResponseDTO.builder()
                .msg("deleted...")
                .build());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam(required = true) Integer id) throws Exception {
        return ResponseEntity.ok(motoS.getById(id));
    }

    @GetMapping("getByTargaLikeA")
    public ResponseEntity<Object> getByTargaLikeA() throws Exception {
        return ResponseEntity.ok(motoS.getByTargaLikeA());
    }

    @GetMapping("list")
    public ResponseEntity<Object> list(
            @RequestParam(required = false) Integer idMoto,
            @RequestParam(required = false) String targa,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modello,
            @RequestParam(required = false) Integer colore,
            @RequestParam(required = false) Integer categoria
    ) throws Exception {
        return ResponseEntity.ok(motoS.list(idMoto, targa, marca, modello, colore, categoria));
    }

}