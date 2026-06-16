package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.output.tipoAlimentazioneDTO;
import com.betacom.jpa.mapping.TipoAlimentazioneMap;
import com.betacom.jpa.models.tipoAlimentazione;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.jpa.services.interfaces.ITipoAlimentazioneServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class TipoAlimentazioneImpl implements ITipoAlimentazioneServices {

    private final ITipoAlimentazioneRepository rep;

    @Override
    public List<tipoAlimentazioneDTO> list() throws Exception {
        log.debug("list tipoAlimentazione");
        return rep.findAll()
                .stream()
                .map(TipoAlimentazioneMap::buildTipoAlimentazioneDTO)
                .toList();
    }

    @Override
    public tipoAlimentazioneDTO getById(Integer id) throws Exception {
        log.debug("getById tipoAlimentazione {}", id);
        tipoAlimentazione t = rep.findById(id)
                .orElseThrow(() -> new AcademyException("alimentazione.ntfnd"));
        return TipoAlimentazioneMap.buildTipoAlimentazioneDTO(t);
    }

}