package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.output.ColoreDTO;

public interface IColoreServices {

    List<ColoreDTO> list() throws Exception;

    ColoreDTO getById(Integer id) throws Exception;
}