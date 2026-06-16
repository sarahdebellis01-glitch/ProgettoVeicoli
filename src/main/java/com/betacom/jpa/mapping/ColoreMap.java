package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.ColoreDTO;
import com.betacom.jpa.models.Colore;

public class ColoreMap {

    public static List<ColoreDTO> buildColoreDTOList(List<Colore> lC) {
        return lC.stream()
                .map(ColoreMap::buildColoreDTO)
                .toList();
    }

    public static ColoreDTO buildColoreDTO(Colore c) {
        return ColoreDTO.builder()
                .idColore(c.getIdColore())
                .nome(c.getNome())
                .build();
    }

}