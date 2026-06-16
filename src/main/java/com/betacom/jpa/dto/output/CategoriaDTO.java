package com.betacom.jpa.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CategoriaDTO {
    private Integer idCategoria;
    private String descrizione;
}