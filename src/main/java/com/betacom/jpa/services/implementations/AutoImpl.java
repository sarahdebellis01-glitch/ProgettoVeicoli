 package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.AutoReq;
import com.betacom.jpa.dto.output.AutoDTO;
import com.betacom.jpa.mapping.AutoMap;
import com.betacom.jpa.models.Auto;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.IAutoRepository;
import com.betacom.jpa.services.interfaces.IAutoServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class AutoImpl implements IAutoServices {

    private final IAutoRepository rep;

    @Transactional
    @Override
    public void create(AutoReq req) throws Exception {

        log.debug("create {}", req);

        if (rep.existsByTarga(req.getTarga()))
            throw new AcademyException("auto.targa.exist");

        Veicoli v = new Veicoli();
        v.setTipoVeicolo("AUTO");
        v.setNumeroRuote(4);
        v.setMarca(req.getVeicolo().getMarca());
        v.setModello(req.getVeicolo().getModello());
        v.setAnnoProduzione(req.getVeicolo().getAnnoProduzione());

        Auto a = new Auto();
        a.setTarga(req.getTarga().toUpperCase());
        a.setCilindrata(req.getCilindrata());
        a.setNumeroPorte(req.getNumeroPorte());
        a.setVeicolo(v);

        rep.save(a);
    }

    @Transactional
    @Override
    public void update(AutoReq req) throws Exception {

        log.debug("update {}", req);

        Auto a = rep.findById(req.getIdAuto())
                .orElseThrow(() -> new AcademyException("auto.notfound"));

        if (req.getTarga() != null &&
                !req.getTarga().equalsIgnoreCase(a.getTarga())) {

            if (rep.existsByTarga(req.getTarga()))
                throw new AcademyException("auto.targa.exist");

            a.setTarga(req.getTarga());
        }

        Optional.ofNullable(req.getCilindrata())
                .ifPresent(a::setCilindrata);

        Optional.ofNullable(req.getNumeroPorte())
                .ifPresent(a::setNumeroPorte);
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {

        log.debug("delete {}", id);

        Auto a = rep.findById(id)
                .orElseThrow(() -> new AcademyException("auto.notfound"));

        rep.delete(a);
    }

    @Override
    public AutoDTO getById(Integer id) throws Exception {

        log.debug("getById {}", id);

        Auto a = rep.findById(id)
                .orElseThrow(() -> new AcademyException("auto.notfound"));

        return AutoMap.buildAutoDTO(a);
    }

    @Override
    public AutoDTO getByTarga(String targa) throws Exception {

        log.debug("getByTarga {}", targa);

        Auto a = rep.findByTarga(targa)
                .orElseThrow(() -> new AcademyException("auto.notfound"));

        return AutoMap.buildAutoDTO(a);
    }

    @Override
    public List<AutoDTO> getByTargaLikeA() throws Exception {
        log.debug("getByTargaLikeA");
        List<Auto> lA = rep.getByTargaLikeA();
        return AutoMap.buildAutoDTOList(lA);
    }

    @Override
    public List<AutoDTO> list(Integer idAuto,
                              String targa,
                              String marca,
                              String modello,
                              Integer colore,
                              Integer categoria) throws Exception {

        log.debug("list : {} / {} / {} / {} / {} / {}",
                idAuto, targa, marca, modello, colore, categoria);

        List<Auto> lA = rep.selectByFilter(idAuto, targa, marca, modello, colore, categoria);

        return AutoMap.buildAutoDTOList(lA);
    }

    @Override
    public List<AutoDTO> findByFilter(
            Integer idAuto,
            String targa,
            String marca,
            String modello,
            Integer colore,
            Integer categoria) throws Exception {

        return rep.selectByFilter(idAuto, targa, marca, modello, colore, categoria)
                .stream()
                .map(AutoMap::buildAutoDTO)
                .toList();
    }

}