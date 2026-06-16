package com.betacom.jpa.dto.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AutoReq {

    @NotNull(groups = ValidationGroups.Update.class, message = "auto.no.id")
    private Integer idAuto;

    /*
     * Targa italiana: 2 lettere + 3 cifre + 2 lettere  (es. AB123CD)
     * Oppure targa speciale con formato diverso — lasciamo il pattern flessibile
     */
    @NotNull(groups = ValidationGroups.Create.class, message = "auto.no.targa")
    @NotBlank(groups = ValidationGroups.Create.class, message = "auto.no.targa")
    @Pattern(
            regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$",
            groups = {ValidationGroups.Create.class, ValidationGroups.Update.class},
            message = "auto.targa.invalid"
    )
    private String targa;

    @NotNull(groups = ValidationGroups.Create.class, message = "auto.no.cilindrata")
    @Min(value = 1, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "auto.cilindrata.invalid")
    private Integer cilindrata;

    /*
     * Numero porte ammesse: 2, 3, 4, 5
     */
    @NotNull(groups = ValidationGroups.Create.class, message = "auto.no.porte")
    @Min(value = 2, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "auto.porte.invalid")
    @Max(value = 5, groups = {ValidationGroups.Create.class, ValidationGroups.Update.class}, message = "auto.porte.invalid")
    private Integer numeroPorte;

    @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.alimentazione")
    private Integer tipoAlimentazioneId;

    private VeicoliReq veicolo;
}