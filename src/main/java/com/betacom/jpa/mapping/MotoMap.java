package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.MotoDTO;
import com.betacom.jpa.models.Moto;

public class MotoMap {

    public static List<MotoDTO> buildMotoDTOList(List<Moto> lM) {
        return lM.stream()
                .map(MotoMap::buildMotoDTO)
                .toList();
    }

    public static MotoDTO buildMotoDTO(Moto m) {
        return MotoDTO.builder()
                .idMoto(m.getIdMoto())
                .targa(m.getTarga())
                .cilindrata(m.getCilindrata())
                .veicolo(VeicoloMap.buildVeicoloDTO(m.getVeicolo()))
                .build();
    }
}