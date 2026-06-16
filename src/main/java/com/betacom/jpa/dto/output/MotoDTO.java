package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class MotoDTO {
    private Integer idMoto;
    private String targa;
    private Integer cilindrata;
    private VeicoliDTO veicolo;
}