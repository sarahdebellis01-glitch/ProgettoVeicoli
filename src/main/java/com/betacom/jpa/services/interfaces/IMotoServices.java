package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.output.MotoDTO;

public interface IMotoServices {

    void create(MotoReq req) throws Exception;

    void update(MotoReq req) throws Exception;

    void delete(Integer idMoto) throws Exception;

    MotoDTO getById(Integer idMoto) throws Exception;

    List<MotoDTO> getByTargaLikeA() throws Exception;

    List<MotoDTO> list(
            Integer idMoto,
            String targa,
            String marca,
            String modello,
            Integer colore,
            Integer categoria
    ) throws Exception;

}