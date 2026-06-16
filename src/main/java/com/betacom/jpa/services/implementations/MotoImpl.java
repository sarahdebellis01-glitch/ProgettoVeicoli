package com.betacom.jpa.services.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.MotoDTO;
import com.betacom.jpa.mapping.MotoMap;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.tipoAlimentazione;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.jpa.services.interfaces.IMotoServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class MotoImpl implements IMotoServices {

    private final IMotoRepository repM;
    private final IColoreRepository repCol;
    private final ICategoriaRepository repCat;
    private final ITipoAlimentazioneRepository repAlim;

    @Transactional
    @Override
    public void create(MotoReq req) throws Exception {
        log.debug("create moto {}", req);

        VeicoliReq vReq = req.getVeicolo();
        if (vReq == null)
            throw new AcademyException("veicolo.no.dati");

        if (repM.existsByTarga(req.getTarga().toUpperCase()))
            throw new AcademyException("moto.targa.exist");

        if (vReq.getAnnoProduzione() > LocalDate.now().getYear())
            throw new AcademyException("veicolo.anno.futuro");

        Colore colore = repCol.findById(vReq.getIdColore())
                .orElseThrow(() -> new AcademyException("colore.ntfnd"));
        Categoria categoria = repCat.findById(vReq.getIdCategoria())
                .orElseThrow(() -> new AcademyException("categoria.ntfnd"));
        tipoAlimentazione alim = repAlim.findById(req.getTipoAlimentazioneId())
                .orElseThrow(() -> new AcademyException("alimentazione.ntfnd"));

        Veicoli v = new Veicoli();
        v.setTipoVeicolo("MOTO");
        v.setNumeroRuote(2);
        v.setModello(vReq.getModello());
        v.setMarca(vReq.getMarca());
        v.setAnnoProduzione(vReq.getAnnoProduzione());
        v.setColore(colore);
        v.setCategoria(categoria);
        v.setTipoAlimentazione(alim);

        Moto m = new Moto();
        m.setTarga(req.getTarga().toUpperCase());
        m.setCilindrata(req.getCilindrata());
        m.setVeicolo(v);

        repM.save(m);
    }

    @Transactional
    @Override
    public void update(MotoReq req) throws Exception {
        log.debug("update moto {}", req);

        Moto m = repM.findById(req.getIdMoto())
                .orElseThrow(() -> new AcademyException("moto.ntfnd"));

        if (req.getTarga() != null && !req.getTarga().equalsIgnoreCase(m.getTarga())) {
            if (repM.existsByTarga(req.getTarga()))
                throw new AcademyException("moto.targa.exist");
            m.setTarga(req.getTarga().toUpperCase());
        }

        Optional.ofNullable(req.getCilindrata()).ifPresent(m::setCilindrata);

        if (req.getTipoAlimentazioneId() != null) {
            tipoAlimentazione alim = repAlim.findById(req.getTipoAlimentazioneId())
                    .orElseThrow(() -> new AcademyException("alimentazione.ntfnd"));
            m.getVeicolo().setTipoAlimentazione(alim);
        }

        if (req.getVeicolo() != null) {
            VeicoliReq vReq = req.getVeicolo();
            Veicoli v = m.getVeicolo();

            Optional.ofNullable(vReq.getModello()).ifPresent(v::setModello);
            Optional.ofNullable(vReq.getMarca()).ifPresent(v::setMarca);

            if (vReq.getAnnoProduzione() != null) {
                if (vReq.getAnnoProduzione() > LocalDate.now().getYear())
                    throw new AcademyException("veicolo.anno.futuro");
                v.setAnnoProduzione(vReq.getAnnoProduzione());
            }

            if (vReq.getIdColore() != null) {
                Colore colore = repCol.findById(vReq.getIdColore())
                        .orElseThrow(() -> new AcademyException("colore.ntfnd"));
                v.setColore(colore);
            }

            if (vReq.getIdCategoria() != null) {
                Categoria categoria = repCat.findById(vReq.getIdCategoria())
                        .orElseThrow(() -> new AcademyException("categoria.ntfnd"));
                v.setCategoria(categoria);
            }
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete moto {}", id);
        Moto m = repM.findById(id)
                .orElseThrow(() -> new AcademyException("moto.ntfnd"));
        repM.delete(m);
    }

    @Override
    public MotoDTO getById(Integer id) throws Exception {
        log.debug("getById moto {}", id);
        Moto m = repM.findById(id)
                .orElseThrow(() -> new AcademyException("moto.ntfnd"));
        return MotoMap.buildMotoDTO(m);
    }

    @Override
    public List<MotoDTO> getByTargaLikeA() throws Exception {
        log.debug("getByTargaLikeA moto");
        return repM.getByTargaLikeA()
                .stream()
                .map(MotoMap::buildMotoDTO)
                .toList();
    }

    @Override
    public List<MotoDTO> list(Integer id, String targa, String marca, String modello,
                               Integer colore, Integer categoria) throws Exception {
        log.debug("list moto: {} / {} / {} / {} / {} / {}", id, targa, marca, modello, colore, categoria);
        List<Moto> lM = repM.findAll();
        return MotoMap.buildMotoDTOList(lM);
    }

}