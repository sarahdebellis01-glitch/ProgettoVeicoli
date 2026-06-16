package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BiciDTO {

    private Integer idBici;
    private String tipoFreno;
    private String tipoSospensione;
    private Integer numeroMarce;
    private Boolean pieghevole;

    // VEICOLO
    private Integer idVeicolo;
    private String marca;
    private String modello;
}