
package com.betacom.jpa.mapping;

import java.util.List;

import com.betacom.jpa.dto.output.BiciDTO;
import com.betacom.jpa.models.Bici;

public class BiciMap {

    public static List<BiciDTO> buildBiciDTOList(List<Bici> listaBici) {
        return listaBici.stream()
                .map(BiciMap::buildBiciDTO)
                .toList();
    }

    public static BiciDTO buildBiciDTO(Bici bici) {

        return BiciDTO.builder()
                .idBici(bici.getIdBici())
                .tipoFreno(bici.getTipoFreno())
                .tipoSospensione(bici.getTipoSospensione())
                .numeroMarce(bici.getNumeroMarce())
                .pieghevole(bici.getPieghevole())

                .idVeicolo(bici.getVeicolo() != null ? bici.getVeicolo().getIdVeicoli() : null)
                .marca(bici.getVeicolo() != null ? bici.getVeicolo().getMarca() : null)
                .modello(bici.getVeicolo() != null ? bici.getVeicolo().getModello() : null)

                .build();
    }
}