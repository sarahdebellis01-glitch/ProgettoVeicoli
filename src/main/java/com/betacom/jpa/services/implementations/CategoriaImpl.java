package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.output.CategoriaDTO;
import com.betacom.jpa.mapping.CategoriaMap;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.services.interfaces.ICategoriaServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoriaImpl implements ICategoriaServices {

    private final ICategoriaRepository rep;

    @Override
    public List<CategoriaDTO> list() throws Exception {
        log.debug("list categorie");
        return rep.findAll()
                .stream()
                .map(CategoriaMap::buildCategoriaDTO)
                .toList();
    }

    @Override
    public CategoriaDTO getById(Integer id) throws Exception {
        log.debug("getById categoria {}", id);
        Categoria c = rep.findById(id)
                .orElseThrow(() -> new AcademyException("categoria.ntfnd"));
        return CategoriaMap.buildCategoriaDTO(c);
    }

}