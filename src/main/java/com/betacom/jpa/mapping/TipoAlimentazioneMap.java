package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.tipoAlimentazioneDTO;
import com.betacom.jpa.models.tipoAlimentazione;

public class TipoAlimentazioneMap {

    public static List<tipoAlimentazioneDTO> buildTipoAlimentazioneDTOList(List<tipoAlimentazione> lT) {
        return lT.stream()
                .map(TipoAlimentazioneMap::buildTipoAlimentazioneDTO)
                .toList();
    }

    public static tipoAlimentazioneDTO buildTipoAlimentazioneDTO(tipoAlimentazione t) {
        return tipoAlimentazioneDTO.builder()
                .idTipoAlimentazione(t.getIdTipoAlimentazione())
                .descrizione(t.getDescrizione())
                .build();
    }

}