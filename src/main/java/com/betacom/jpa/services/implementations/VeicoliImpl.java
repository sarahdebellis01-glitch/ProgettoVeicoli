package com.betacom.jpa.services.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.VeicoliReq;
import com.betacom.jpa.dto.output.VeicoliDTO;
import com.betacom.jpa.mapping.VeicoloMap;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.tipoAlimentazione;
import com.betacom.jpa.models.Veicoli;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.ITipoAlimentazioneRepository;
import com.betacom.jpa.repositories.IVeicoliRepository;
import com.betacom.jpa.services.interfaces.IVeicoliServices;

import exceptions.AcademyException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class VeicoliImpl implements IVeicoliServices {

    private final IVeicoliRepository repV;
    private final IColoreRepository repCol;
    private final ICategoriaRepository repCat;
    private final ITipoAlimentazioneRepository repAlim;

    @Transactional
    @Override
    public void create(VeicoliReq req) throws Exception {
        log.debug("create veicolo {}", req);

        if (req.getAnnoProduzione() > LocalDate.now().getYear())
            throw new AcademyException("veicolo.anno.futuro");

        Colore colore = repCol.findById(req.getIdColore())
                .orElseThrow(() -> new AcademyException("colore.ntfnd"));

        Categoria categoria = repCat.findById(req.getIdCategoria())
                .orElseThrow(() -> new AcademyException("categoria.ntfnd"));

        tipoAlimentazione alim = null;
        if (req.getIdTipoAlimentazione() != null) {
            alim = repAlim.findById(req.getIdTipoAlimentazione())
                    .orElseThrow(() -> new AcademyException("alimentazione.ntfnd"));
        }

        Veicoli v = new Veicoli();
        v.setTipoVeicolo(req.getTipoVeicolo().toUpperCase());
        v.setNumeroRuote(req.getNumeroRuote());
        v.setModello(req.getModello());
        v.setMarca(req.getMarca());
        v.setAnnoProduzione(req.getAnnoProduzione());
        v.setColore(colore);
        v.setCategoria(categoria);
        v.setTipoAlimentazione(alim);

        repV.save(v);
    }

    @Transactional
    @Override
    public void update(VeicoliReq req) throws Exception {
        log.debug("update veicolo {}", req);

        Veicoli v = repV.findById(req.getIdVeicolo())
                .orElseThrow(() -> new AcademyException("veicolo.ntfnd"));

        Optional.ofNullable(req.getModello()).ifPresent(v::setModello);
        Optional.ofNullable(req.getMarca()).ifPresent(v::setMarca);

        if (req.getTipoVeicolo() != null)
            v.setTipoVeicolo(req.getTipoVeicolo().toUpperCase());

        Optional.ofNullable(req.getNumeroRuote()).ifPresent(v::setNumeroRuote);

        if (req.getAnnoProduzione() != null) {
            if (req.getAnnoProduzione() > LocalDate.now().getYear())
                throw new AcademyException("veicolo.anno.futuro");
            v.setAnnoProduzione(req.getAnnoProduzione());
        }

        if (req.getIdColore() != null) {
            Colore colore = repCol.findById(req.getIdColore())
                    .orElseThrow(() -> new AcademyException("colore.ntfnd"));
            v.setColore(colore);
        }

        if (req.getIdCategoria() != null) {
            Categoria categoria = repCat.findById(req.getIdCategoria())
                    .orElseThrow(() -> new AcademyException("categoria.ntfnd"));
            v.setCategoria(categoria);
        }

        if (req.getIdTipoAlimentazione() != null) {
            tipoAlimentazione alim = repAlim.findById(req.getIdTipoAlimentazione())
                    .orElseThrow(() -> new AcademyException("alimentazione.ntfnd"));
            v.setTipoAlimentazione(alim);
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        log.debug("delete veicolo {}", id);
        Veicoli v = repV.findById(id)
                .orElseThrow(() -> new AcademyException("veicolo.ntfnd"));
        repV.delete(v);
    }

    @Override
    public List<VeicoliDTO> list() throws Exception {
        log.debug("list veicoli");
        return repV.findAll()
                .stream()
                .map(VeicoloMap::buildVeicoloDTO)
                .toList();
    }

    @Override
    public VeicoliDTO getById(Integer id) throws Exception {
        log.debug("getById veicolo {}", id);
        Veicoli v = repV.findById(id)
                .orElseThrow(() -> new AcademyException("veicolo.ntfnd"));
        return VeicoloMap.buildVeicoloDTO(v);
    }
    
    @Transactional
	@Override
	public List<VeicoliDTO> findByFilter(
	        Integer idVeicolo,
	        String tipoVeicolo,
	        String marca,
	        String modello,
	        Integer colore,
	        Integer categoria,
	        Integer alimentazione) throws Exception {

	    log.debug("findByFilter");

	    return repV.selectByFilter(
	            idVeicolo,
	            tipoVeicolo,
	            marca,
	            modello,
	            colore,
	            categoria,
	            alimentazione)
	            .stream()
	            .map(VeicoloMap::buildVeicoloDTO)
	            .toList();
	}
    
    @Transactional
	@Override
	public List<VeicoliDTO> getByMarcaLikeA() throws Exception {
		 log.debug("getByMarcaLikeA");
	        
		 // Recupera la lista dal repository usando il filtro per marca
	        return repV.getByMarcaLikeA()
	                .stream()
	                .map(VeicoloMap::buildVeicoloDTO)
	                .toList();
	}
	
}