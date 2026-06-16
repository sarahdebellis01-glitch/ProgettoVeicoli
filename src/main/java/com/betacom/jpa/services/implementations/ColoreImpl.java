package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.output.ColoreDTO;
import com.betacom.jpa.mapping.ColoreMap;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.services.interfaces.IColoreServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ColoreImpl implements IColoreServices {

    private final IColoreRepository rep;

    @Override
    public List<ColoreDTO> list() throws Exception {
        log.debug("list colori");
        return rep.findAll()
                .stream()
                .map(ColoreMap::buildColoreDTO)
                .toList();
    }

    @Override
    public ColoreDTO getById(Integer id) throws Exception {
        log.debug("getById colore {}", id);
        Colore c = rep.findById(id)
                .orElseThrow(() -> new AcademyException("colore.ntfnd"));
        return ColoreMap.buildColoreDTO(c);
    }

}