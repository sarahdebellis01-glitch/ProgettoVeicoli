package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeicoliReq {

    @NotNull(groups = ValidationGroups.Update.class, message = "veicolo.no.id")
    private Integer idVeicolo;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.modello")
    @NotBlank(groups = ValidationGroups.Create.class, message = "veicolo.no.modello")
    private String modello;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.marca")
    @NotBlank(groups = ValidationGroups.Create.class, message = "veicolo.no.marca")
    private String marca;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.annoProduzione")
    @Min(value = 1886, groups = ValidationGroups.Create.class, message = "veicolo.anno.invalid")
    private Integer annoProduzione;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.colore")
    private Integer IdColore;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.categoria")
    private Integer idCategoria;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.tipoAlimentazione")
    private Integer idTipoAlimentazione;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.tipoVeicolo")
    @NotBlank(groups = ValidationGroups.Create.class, message = "veicolo.no.tipoVeicolo")
    private String tipoVeicolo;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.numeroRuote")
    @Min(value = 1, groups = ValidationGroups.Create.class, message = "veicolo.ruote.invalid")
    private Integer numeroRuote;
}