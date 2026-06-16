package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.AutoDTO;
import com.betacom.jpa.models.Auto;

public class AutoMap {

    public static List<AutoDTO> buildAutoDTOList(List<Auto> lA) {
        return lA.stream()
                .map(AutoMap::buildAutoDTO)
                .toList();
    }

    public static AutoDTO buildAutoDTO(Auto a) {
        return AutoDTO.builder()
                .idAuto(a.getIdAuto())
                .targa(a.getTarga())
                .cilindrata(a.getCilindrata())
                .numeroPorte(a.getNumeroPorte())
                .veicolo(VeicoloMap.buildVeicoloDTO(a.getVeicolo()))
                .build();
    }
}