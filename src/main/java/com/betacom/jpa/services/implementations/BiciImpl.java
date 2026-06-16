package com.betacom.jpa.services.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.BiciDTO;
import com.betacom.jpa.mapping.BiciMap;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.services.interfaces.IBiciServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class BiciImpl implements IBiciServices {

    private final IBiciRepository repB;
    private final IColoreRepository repCol;
    private final ICategoriaRepository repCat;

    @Transactional
    @Override
    public void create(BiciReq req) throws Exception {
        log.debug("create bici {}", req);

        VeicoliReq vReq = req.getVeicolo();
        if (vReq == null)
            throw new AcademyException("veicolo.no.dati");

        if (vReq.getAnnoProduzione() > LocalDate.now().getYear())
            throw new AcademyException("veicolo.anno.futuro");

        Colore colore = repCol.findById(vReq.getIdColore())
                .orElseThrow(() -> new AcademyException("colore.ntfnd"));
        Categoria categoria = repCat.findById(vReq.getIdCategoria())
                .orElseThrow(() -> new AcademyException("categoria.ntfnd"));

        if (req.getNumeroMarce() < 1 || req.getNumeroMarce() > 33)
            throw new AcademyException("bici.marce.invalid");

        Veicoli v = new Veicoli();
        v.setTipoVeicolo("BICI");
        v.setNumeroRuote(2);
        v.setModello(vReq.getModello());
        v.setMarca(vReq.getMarca());
        v.setAnnoProduzione(vReq.getAnnoProduzione());
        v.setColore(colore);
        v.setCategoria(categoria);
        v.setTipoAlimentazione(null);

        Bici b = new Bici();
        b.setTipoFreno(req.getTipoFreno());
        b.setTipoSospensione(req.getTipoSospensione());
        b.setNumeroMarce(req.getNumeroMarce());
        b.setPieghevole(req.getPieghevole());
        b.setVeicolo(v);

        repB.save(b);
    }

    @Transactional
    @Override
    public void update(BiciReq req) throws Exception {
        log.debug("update bici {}", req);

        Bici b = repB.findById(req.getIdBici())
                .orElseThrow(() -> new AcademyException("bici.ntfnd"));

        Optional.ofNullable(req.getTipoFreno()).ifPresent(b::setTipoFreno);
        Optional.ofNullable(req.getTipoSospensione()).ifPresent(b::setTipoSospensione);
        Optional.ofNullable(req.getPieghevole()).ifPresent(b::setPieghevole);

        if (req.getNumeroMarce() != null) {
            if (req.getNumeroMarce() < 1 || req.getNumeroMarce() > 33)
                throw new AcademyException("bici.marce.invalid");
            b.setNumeroMarce(req.getNumeroMarce());
        }

        if (req.getVeicolo() != null) {
            VeicoliReq vReq = req.getVeicolo();
            Veicoli v = b.getVeicolo();

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
        log.debug("delete bici {}", id);
        Bici b = repB.findById(id)
                .orElseThrow(() -> new AcademyException("bici.ntfnd"));
        repB.delete(b);
    }

    @Override
    public BiciDTO getById(Integer id) throws Exception {
        log.debug("getById bici {}", id);
        Bici b = repB.findById(id)
                .orElseThrow(() -> new AcademyException("bici.ntfnd"));
        return BiciMap.buildBiciDTO(b);
    }

    @Override
    public List<BiciDTO> getByMarcaLikeA() throws Exception {
        log.debug("getByMarcaLikeA bici");
        return repB.getByMarcaLikeA()
                .stream()
                .map(BiciMap::buildBiciDTO)
                .toList();
    }

    @Override
    public List<BiciDTO> list(Integer id, String marca, String modello,
                               Integer colore, Integer categoria, Boolean pieghevole) throws Exception {
        log.debug("list bici: {} / {} / {} / {} / {} / {}", id, marca, modello, colore, categoria, pieghevole);
        List<Bici> lB = repB.selectByFilter(id, marca, modello, colore, categoria, pieghevole);
        return BiciMap.buildBiciDTOList(lB);
    }

}