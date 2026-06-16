package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.VeicoliDTO;


public interface IVeicoliServices {
	 void create(VeicoliReq req) throws Exception;

	    void update(VeicoliReq req) throws Exception;

	    void delete(Integer id) throws Exception;

	    List<VeicoliDTO> list() throws Exception;

	    VeicoliDTO getById(Integer id) throws Exception;
	    
	    List<VeicoliDTO> findByFilter(
	            Integer idVeicolo,
	            String tipoVeicolo,
	            String marca,
	            String modello,
	            Integer colore,
	            Integer categoria,
	            Integer alimentazione
	    ) throws Exception;

	    List<VeicoliDTO> getByMarcaLikeA() throws Exception;
}