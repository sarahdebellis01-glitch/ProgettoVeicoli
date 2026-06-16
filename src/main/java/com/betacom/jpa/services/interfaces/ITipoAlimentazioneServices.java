package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.output.tipoAlimentazioneDTO;

public interface ITipoAlimentazioneServices {
	 List<tipoAlimentazioneDTO> list() throws Exception;

	    tipoAlimentazioneDTO getById(Integer id) throws Exception;

}