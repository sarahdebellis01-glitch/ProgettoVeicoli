package com.betacom.jpa.mapping;

import com.betacom.jpa.dto.output.VeicoliDTO;

import java.util.List;

import com.betacom.jpa.dto.output.CategoriaDTO;
import com.betacom.jpa.dto.output.ColoreDTO;
import com.betacom.jpa.dto.output.tipoAlimentazioneDTO;
import com.betacom.jpa.dto.output.VeicoliDTO;
import com.betacom.jpa.models.Veicoli;

public class VeicoloMap {

    public static VeicoliDTO buildVeicoloDTO(Veicoli v) {
        if (v == null) return null;
        return VeicoliDTO.builder()
                .idVeicoli(v.getIdVeicoli())
                .tipoVeicolo(v.getTipoVeicolo())
                .numeroRuote(v.getNumeroRuote())
                .modello(v.getModello())
                .annoProduzione(v.getAnnoProduzione())
                .marca(v.getMarca())
                .colore(v.getColore() == null ? null : ColoreDTO.builder()
                        .idColore(v.getColore().getIdColore())
                        .nome(v.getColore().getNome())
                        .build()
                )
                .categoria(v.getCategoria() == null ? null : CategoriaDTO.builder()
                        .idCategoria(v.getCategoria().getIdCategoria())
                        .descrizione(v.getCategoria().getDescrizione())
                        .build()
                )
                .tipoAlimentazione(v.getTipoAlimentazione() == null ? null : tipoAlimentazioneDTO.builder()
                        .idTipoAlimentazione(v.getTipoAlimentazione().getIdTipoAlimentazione())
                        .descrizione(v.getTipoAlimentazione().getDescrizione())
                        .build()
                )
                .build();
    }
}