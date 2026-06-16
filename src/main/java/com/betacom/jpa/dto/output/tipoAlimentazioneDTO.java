package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class tipoAlimentazioneDTO {
    private Integer idTipoAlimentazione;
    private String descrizione;
}