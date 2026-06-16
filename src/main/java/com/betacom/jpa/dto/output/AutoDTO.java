package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AutoDTO {
    private Integer idAuto;
    private String targa;
    private String marca;
    private String modello;
    private Integer cilindrata;
    private Integer numeroPorte;
    private VeicoliDTO veicolo;
}