package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.AutoReq;
import com.betacom.jpa.dto.output.AutoDTO;

public interface IAutoServices {

    void create(AutoReq req) throws Exception;

    void update(AutoReq req) throws Exception;

    void delete(Integer idAuto) throws Exception;

    AutoDTO getById(Integer idAuto) throws Exception;

    AutoDTO getByTarga(String targa) throws Exception;

    List<AutoDTO> getByTargaLikeA() throws Exception;

    List<AutoDTO> findByFilter(
            Integer idAuto,
            String targa,
            String marca,
            String modello,
            Integer colore,
            Integer categoria
    ) throws Exception;

    List<AutoDTO> list(
            Integer idAuto,
            String targa,
            String marca,
            String modello,
            Integer colore,
            Integer categoria
    ) throws Exception;

}