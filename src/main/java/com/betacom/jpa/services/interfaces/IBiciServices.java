package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.output.BiciDTO;

public interface IBiciServices {

    void create(BiciReq req) throws Exception;

    void update(BiciReq req) throws Exception;

    void delete(Integer idBici) throws Exception;

    BiciDTO getById(Integer idBici) throws Exception;

    List<BiciDTO> getByMarcaLikeA() throws Exception;

    List<BiciDTO> list(
            Integer idBici,
            String marca,
            String modello,
            Integer colore,
            Integer categoria,
            Boolean pieghevole
    ) throws Exception;

}