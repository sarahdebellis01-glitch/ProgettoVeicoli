package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class VeicoliDTO {
    private Integer idVeicoli;
    private String tipoVeicolo;
    private Integer numeroRuote;
    private String modello;
    private Integer annoProduzione;
    private String marca;
    private ColoreDTO colore;
    private CategoriaDTO categoria;
    private tipoAlimentazioneDTO tipoAlimentazione;
}