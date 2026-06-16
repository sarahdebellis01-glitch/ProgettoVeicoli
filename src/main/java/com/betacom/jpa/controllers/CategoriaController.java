package com.betacom.jpa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.services.interfaces.ICategoriaServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/categoria")
public class CategoriaController {

    private final ICategoriaServices categoriaS;

    @GetMapping("list")
    public ResponseEntity<Object> list() throws Exception {
        return ResponseEntity.ok(categoriaS.list());
    }

    @GetMapping("getById")
    public ResponseEntity<Object> getById(@RequestParam(required = true) Integer id) throws Exception {
        return ResponseEntity.ok(categoriaS.getById(id));
    }

}