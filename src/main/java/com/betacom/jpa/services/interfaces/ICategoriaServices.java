package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.output.CategoriaDTO;

public interface ICategoriaServices {
	 List<CategoriaDTO> list() throws Exception;

	    CategoriaDTO getById(Integer id) throws Exception;

}