package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoReq {

    @NotNull(groups = ValidationGroups.Update.class, message = "moto.no.id")
    private Integer idMoto;

    @NotNull(groups = ValidationGroups.Create.class, message = "moto.no.targa")
    @NotBlank(groups = ValidationGroups.Create.class, message = "moto.no.targa")
    @Pattern(
        regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$",
        groups = {ValidationGroups.Create.class, ValidationGroups.Update.class},
        message = "moto.targa.invalid"
    )
    private String targa;

    @NotNull(groups = ValidationGroups.Create.class, message = "moto.no.cilindrata")
    @Min(value = 1, message = "moto.cilindrata.invalid")
    private Integer cilindrata;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.alimentazione")
    private Integer tipoAlimentazioneId;

    private VeicoliReq veicolo;
}