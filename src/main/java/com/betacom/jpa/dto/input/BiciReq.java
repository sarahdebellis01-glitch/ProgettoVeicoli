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
public class BiciReq {

    @NotNull(groups = ValidationGroups.Update.class, message = "bici.no.id")
    private Integer idBici;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    private String tipoFreno;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoSospensione")
    private String tipoSospensione;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.numeroMarce")
    @Min(value = 1, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "bici.marce.invalid")
    private Integer numeroMarce;

    @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.pieghevole")
    private Boolean pieghevole;

    private VeicoliReq veicolo;
}