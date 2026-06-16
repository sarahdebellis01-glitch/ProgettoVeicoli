package com.betacom.jpa.dto.input;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ColoreReq {
	 @NotNull(groups = ValidationGroups.Create.class, message = "veicolo.no.colore")
	private Integer id;
	 @NotNull(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
	 @NotBlank(groups = ValidationGroups.Create.class, message = "bici.no.tipoFreno")
    private String nome;
}
